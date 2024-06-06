package com.example.literarylane

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.literarylane.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), BookClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateBooks()

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = CardAdapter(bookList, this@HomeFragment)
        }
    }

    override fun onClick(book: Book) {
        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra(BOOK_ID_EXTRA, book.id)
        }
        startActivity(intent)
    }

    private fun populateBooks() {
        bookList.clear() // Clear existing list

        val books = listOf(
            Book(
                R.drawable.bravenewworld_cover,
                "Aldous Huxley",
                "Brave New World",
                "Aldous Huxley's profoundly important classic of world literature, Brave New World is a searching vision of an unequal, technologically-advanced future where humans are genetically bred, socially indoctrinated, and pharmaceutically anesthetized to passively uphold an authoritarian ruling order–all at the cost of our freedom, full humanity, and perhaps also our souls.",
                "https://annas-archive.org/md5/66ce460cf04e4684749a52de3e5cbbd5",
                1
            ),

            Book(
                R.drawable.nineteeneightyfour_cover,
                "George Orwell",
                "Nineteen Eighty-Four",
                "A dystopian novel that portrays a totalitarian society where personal freedom is non-existent. It warns against the dangers of totalitarian power, surveillance, propaganda, and thought control, in a powerful critique of modern society.",
                "https://annas-archive.org/md5/16da63d97093b40476e3689e4c2bd1da",
                2
            ),

            Book(
                R.drawable.thehandmaidstale_cover,
                "Margaret Atwood",
                "The Handmaid's Tale",
                "'A dystopian novel about a woman's struggles in a totalitarian society where her identity, fertility and freedoms are suppressed. Through Offred's journey, the book highlights the dangers of extremist religious beliefs and the importance of individual resistance.",
                "https://annas-archive.org/md5/f5dcaaf7e5fae59fd1174c41c722fdcb",
                3
            ),

        Book(
            R.drawable.thehungergame_cover,
            "Suzanne Collins",
            "The Hunger Games",
            "An annual event in which one boy and one girl aged 12–18 from each of the twelve districts surrounding the Capitol are selected by lottery to compete in a televised battle royale to the death. ",
            "https://annas-archive.org/md5/409b20166b367ac75a07bac7439aab12",
            4
        ),

        Book(
            R.drawable.thetimemachine_cover,
            "H.G. Wells",
            "The Time Machine",
            "Offers a dystopian vision of humanity's future. A scientist builds a time machine and travels to future. He finds that humanity has devolved into two races: the childlike Eloi and the monstrous Morlocks. His machine disappears, so he explores the future world.",
            "https://annas-archive.org/md5/256a737415ed4247d3d457f5501f0917",
            5
        ),

        Book(
            R.drawable.circe_cover,
            "Madeline Miller",
            "Circe",
            "Through the charms of a misfit heroine, the world of gods becomes stunningly alive, and the world of our own humanity; its questions, loves, and bonds is illuminated",
            "https://annas-archive.org/md5/1bf9770951851611b66713a73aa381c0",
            6
        ),


        Book(
            R.drawable.cruelprince_cover,
            "Holly Black",
            "The Cruel Prince",
            "Follows Jude Duarte, a human living in Elfhame, a world with faerie's. Jude longs to be a knight, but her father forbids her. It is a story about overcoming discrimination, as Jude is often bullied by the King's children, and especially Prince Cardan.",
            "https://annas-archive.org/md5/f286284d32a18f1b00be20d121fd27c3",
            7
        ),

        Book(
            R.drawable.sixeofcrows_cover,
            "Leigh Bardugo",
            "Six of Crows",
            "Follows the adventures of six teenage criminals hired to undertake a dangerous heist, while searching for love and redemption along the way. The leader of the group is Kaz Brekker, the cunning, ruthless leader of the Dregs, one of many street gangs in the port city of Ketterdam.",
            "https://annas-archive.org/md5/479ffb6bcbf8803c931d94a9f6d8f67b",
            8
        ),

        Book(
            R.drawable.thenightcircus_cover,
            "Erin Morgenstern",
            "The Night Circus",
            "The Night Circus is a phantasmagorical fairy tale set near an ahistorical Victorian London in a wandering, magical circus that is open only from sunset to sunrise.",
            "https://annas-archive.org/md5/fb7aec03cc2d90b9f4759e9f968fd1d8",
            9
        ),

        Book(
            R.drawable.thepoppywar_cover,
            "R. F. Kuang",
            "The Poppy War",
            "The Poppy War, a grimdark fantasy, draws its plot and politics from mid-20th-century China, with the conflict in the novel based on the Second Sino-Japanese War, and an atmosphere inspired by the Song dynasty.",
            "https://annas-archive.org/md5/49a3d0123077571f43d40324af994ad6",
            10
        ),

        Book(
            R.drawable.thesongofachilles_cover,
            "Madeline Miller",
            "The Song of Achilles",
            "Set during the Greek Heroic Age, it is a retelling of the Trojan War as told from the perspective of Patroclus. The novel follows Patroclus' relationship with Achilles, from their initial meeting to their exploits during the Trojan War, with focus on their romantic relationship.",
            "https://annas-archive.org/md5/81d55ba9fbe0bad7631212430767b25e",
            11
        ),

        Book(
            R.drawable.dracula_cover,
            "Bram Stoker",
            "Dracula",
            "An epistolary novel, the narrative is related through letters, diary entries, and newspaper articles. It has no single protagonist and opens with solicitor Jonathan Harker taking a business trip to stay at the castle of a Transylvanian nobleman, Count Dracula.",
            "https://annas-archive.org/md5/993faabea73fb05fcf2b07e562b744cb",
            12
        ),

        Book(
            R.drawable.frankenstein_cover,
            "Mary Shelley",
            "Frankenstein",
            "Frankenstein tells the story of Victor Frankenstein, a young scientist who creates a sapient creature in an unorthodox scientific experiment. Shelley started writing the story when she was 18, and the first edition was published anonymously in London on 1 January 1818, when she was 20.",
            "https://annas-archive.org/md5/9cee5d8e85b627a583e28b25e2a71aa3",
            13
        ),

        Book(
            R.drawable.it_cover,
            "Stephen King",
            "It",
            "The story follows the experiences of seven children as they are terrorized by an evil entity that exploits the fears of its victims to disguise itself while hunting its prey.",
            "https://annas-archive.org/md5/baaba1a89ef84a2e51b6b55fde1df509",
            14
        ),

        Book(
            R.drawable.theexorcist_cover,
            "William Peter Blatty",
            "The Exorcist",
            "The book details the demonic possession of eleven year old Regan MacNeil, the daughter of a famous actress, and the two priests who attempt to exorcize the demon.",
            "https://annas-archive.org/md5/b65c0db4fd63efaf8ec51e3d26c97373",
            15
        ),

        Book(
            R.drawable.thehauntingofhillhouse_cover,
            "Shirley Jackson",
            "The Haunting of Hill House",
            "The series follows the fractured Crain family as they deal with trauma across two timelines. We follow them as adults in the aftermath of the suicide of one of their own, and as kids living in what would later come to be known as the most haunted house in the country.",
            "https://annas-archive.org/md5/7974563aa114f3d8fe37b156ad350669",
            16
        ),

        Book(
            R.drawable.theshining_cover,
            "Stephen King",
            "The Shining",
            "The Shining is a Gothic horror novel about a family being the caretakers of The Overlook. The Overlook is a hotel in the Colorado Mountains which needs to be tended to when it is closed during the winter months. However, the hotel has an evil past and presence. The evil of the hotel destroys the family.",
            "https://annas-archive.org/md5/941eeb666a31c85be9486ef0fc80a20d",
            17
        ),

        Book(
            R.drawable.aristotleanddante_cover,
            "Benjamin Alire Sáenz",
            "Aristotle and Dante Discover the Secrets of the Universe",
            "This young adult novel follows the deepening friendship between two Mexican-American boys, Aristotle Mendoza and Dante Quintana, as they navigate the challenges of adolescence in the 1980s. Through their bond, they explore themes of identity, family, and love, ultimately discovering profound truths about themselves and each other. The book is acclaimed for its sensitive portrayal of LGBTQ+ issues and its lyrical prose.",
            "https://annas-archive.org/md5/d9ba1054380967921c43a12376712378",
            18
        ),

        Book(
            R.drawable.felixeverafter_cover,
            "Kacen Callender",
            "Felix Ever After",
            "Felix Ever After is a contemporary young adult novel that follows the journey of Felix Love, a Black, queer, transgender teenager navigating life, love, and identity in New York City. Despite his name, Felix has never been in love and is desperate to experience it. His life takes an unexpected turn when an anonymous student publicly reveals Felix's deadname and photos from before his transition. As Felix deals with the fallout, he embarks on a quest for revenge, but his journey leads to self-discovery and a deeper understanding of what love means, both for himself and from others. The novel touches on themes of self-acceptance, the complexity of identity, and the search for belonging and love.",
            "https://annas-archive.org/md5/5645bfee1564b79d7f90db26bf3e05a5",
            19
        ),

        Book(
            R.drawable.lordofflies_cover,
            "William Golding",
            "Lord of the Flies",
            "Lord of the Flies is a novel that explores the descent into savagery of a group of British boys stranded on an uninhabited island. Without adult supervision, their attempt to govern themselves quickly devolves into chaos and violence, revealing dark aspects of human nature and societal breakdown. The novel delves into themes of civilization versus barbarism, the loss of innocence, and the inherent evil within humanity.",
            "https://annas-archive.org/md5/1605ce389bd3065fa5ab683ec330b293",
            20
        ),

        Book(
            R.drawable.thefaultinourstars_cover,
            "John Green",
            "The Fault in Our Stars",
            "The Fault in Our Stars is a poignant young adult novel that tells the story of Hazel Grace Lancaster, a sixteen-year-old cancer patient, and Augustus Waters, a charming and witty boy she meets at a cancer support group. The narrative explores their deepening relationship, their philosophical musings about life and death, and their journey to meet a reclusive author in Amsterdam. With a blend of humor and heartbreak, the book delves into themes of love, loss, and the search for meaning in the face of terminal illness.",
            "https://annas-archive.org/md5/5232198ea290977e251cdc28e1739f5b",
            21
        ),

        Book(
            R.drawable.thegiver_cover,
            "Lois Lowry",
            "The Giver",
            "The Giver is a dystopian young adult novel that explores a seemingly perfect society devoid of pain, suffering, and emotional depth. The protagonist, Jonas, is selected to inherit the position of Receiver of Memory, a role that involves absorbing the past memories of the community. Through these memories, Jonas uncovers the dark truths behind his society's facade of perfection and grapples with the moral complexities of free will, individuality, and the essence of human experience. As he learns more, Jonas must make difficult choices about his own future and the future of those he loves.",
            "https://annas-archive.org/md5/547d1f13d9d29d9d8925c83120a59c4a",
            22
        ),

        Book(
            R.drawable.thesisterhoodofthetravelingpants_cover,
            "Ann Brashares",
            "The Sisterhood of the Traveling Pants",
            "The Sisterhood of the Traveling Pants follows the lives of four best friends—Carmen, Tibby, Bridget, and Lena—as they spend their first summer apart. Before separating, they discover a pair of jeans that miraculously fits each of them perfectly, despite their different body types. The pants become a symbol of their friendship and are shared among the girls throughout the summer, accompanying each on her personal journey of growth, challenges, and self-discovery. The story beautifully captures the essence of teenage friendship, the bittersweet nature of growing up, and the enduring bond that keeps them connected.",
            "https://annas-archive.org/md5/a0fbc03266662b8467738fd4999843f8",
            23
        ),

        Book(
            R.drawable.callmebyyourname_cover,
            "André Aciman",
            "Call Me by Your Name",
            "Call Me by Your Name is a tender and passionate love story set in the Italian Riviera during the summer of 1983. It follows the blossoming romance between Elio, a 17-year-old boy, and Oliver, a 24-year-old American scholar staying with Elio's family. The novel explores themes of desire, identity, and the fleeting nature of first love with profound emotional depth and lyrical prose.",
            "https://annas-archive.org/md5/3b5dd391b8a2d4cdb84ec45597b7b75a",
            24
        ),

        Book(
            R.drawable.prideandprejudice_cover,
            "Jane Austen",
            "Pride and Prejudice",
            "Pride and Prejudice is a classic novel set in early 19th-century England that centers on the tumultuous relationship between Elizabeth Bennet and Fitzwilliam Darcy. With wit and insight, Austen critiques social class, marriage, and the expectations placed on women, while weaving a story of misunderstandings, personal growth, and enduring love.",
            "https://annas-archive.org/md5/ff33fdf81544275b33dd243565487bc7",
            25
        ),

        Book(
            R.drawable.redwhitenroyalblue_cover,
            "Casey McQuiston",
            "Red, White & Royal Blue",
            "Red, White & Royal Blue is a contemporary romance that imagines a love affair between Alex Claremont-Diaz, the First Son of the United States, and Prince Henry of Wales. When a PR mishap forces them to fake a friendship, their animosity turns to genuine affection and then to a secret, whirlwind romance that challenges their public roles and personal identities.",
            "https://annas-archive.org/md5/08a75aeec4b1be927770d565377b5c39",
            26
        ),

        Book(
            R.drawable.thenotebook_cover,
            "Nicholas Sparks",
            "The Notebook",
            "The Notebook is a poignant love story that recounts the lifelong romance between Noah Calhoun and Allie Nelson. Through a series of flashbacks, the novel details their passionate summer affair, the years they spend apart, and their eventual reunion. It's a tale of enduring love and the power of memories to transcend time and adversity.",
            "https://annas-archive.org/md5/695e47fdc1a2436a3474299d8d09ea9f",
            27
        ),

        Book(
            R.drawable.thesevenhusbandsofevelynhugo_cover,
            "Taylor Jenkins Reid",
            "The Seven Husbands of Evelyn Hugo",
            "The Seven Husbands of Evelyn Hugo tells the story of a reclusive Hollywood icon, Evelyn Hugo, who chooses an unknown journalist, Monique Grant, to write her biography. As Evelyn recounts her glamorous and scandalous life, marked by her seven marriages, she reveals secrets, heartbreaks, and a hidden love that defined her. The novel explores themes of identity, ambition, and the cost of fame.",
            "https://annas-archive.org/md5/7050ad354c02b794da9052c2d17e700b",
            28
        ),

        Book(
            R.drawable.todaytonighttomorrow_cover,
            "Rachel Lynn Solomon",
            "Today Tonight Tomorrow",
            "Today Tonight Tomorrow follows high school rivals Rowan Roth and Neil McNair during their last day of senior year. Competing for the title of valedictorian and engaged in a fierce academic rivalry, they find themselves unexpectedly teaming up for an all-night scavenger hunt around Seattle. As they confront their past and their feelings, they discover that their animosity might be hiding a deeper connection.",
            "https://annas-archive.org/md5/6178e83c87db315867bc555043c8347b",
            29
        )
        )//The List of books and variables

        bookList.addAll(books.shuffled())
    }
}
