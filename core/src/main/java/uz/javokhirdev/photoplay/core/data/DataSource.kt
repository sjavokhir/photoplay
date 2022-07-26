package uz.javokhirdev.photoplay.core.data

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Download
import uz.javokhirdev.photoplay.core.domain.model.GroupMovie
import uz.javokhirdev.photoplay.core.domain.model.Movie

object DataSource {

    fun getWatchings(): List<Movie> = movies
    fun getDownloads(): List<Download> = downloads
    fun getActors(): List<Actor> = actors

    fun getSearch(): List<GroupMovie> {
        val series = movies.subList(0, 1)
        val movies = movies.shuffled().subList(0, 3)
        val searchList = ArrayList<GroupMovie>().apply {
            add(GroupMovie("TV Shows", series))
            add(GroupMovie("Movies", movies))
        }

        return searchList
    }

    private val movies = arrayListOf(
        Movie(
            id = 1,
            name = "Narcos",
            description = "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar, as well as the many other drug kingpins who plagued the country through the years.",
            imageUrl = "file:///android_asset/movies/image_01.png",
            rating = 4.4f,
            genres = arrayListOf("Series", "Biography", "Crime", "Drama")
        ),
        Movie(
            id = 2,
            name = "Deadpool 2",
            description = "Foul-mouthed mutant mercenary Wade Wilson (a.k.a. Deadpool) assembles a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg Cable.",
            imageUrl = "file:///android_asset/movies/image_02.png",
            rating = 3.9f,
            genres = arrayListOf("Movie", "Action", "Adventure", "Comedy")
        ),
        Movie(
            id = 3,
            name = "Annabelle",
            description = "A couple begins to experience terrifying supernatural occurrences involving a vintage doll shortly after their home is invaded by satanic cultists.",
            imageUrl = "file:///android_asset/movies/image_03.png",
            rating = 2.7f,
            genres = arrayListOf("Movie", "Horror", "Thriller", "Mystery")
        ),
        Movie(
            id = 4,
            name = "Toy Story 4",
            description = "When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.",
            imageUrl = "file:///android_asset/movies/image_04.png",
            rating = 3.9f,
            genres = arrayListOf("Animation", "Adventure", "Comedy", "Family")
        ),
        Movie(
            id = 5,
            name = "Ant-Man",
            description = "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, pull off a plan that will save the world.",
            imageUrl = "file:///android_asset/movies/image_05.png",
            rating = 3.7f,
            genres = arrayListOf("Movie", "Action", "Comedy", "Adventure")
        ),
        Movie(
            id = 6,
            name = "Crash",
            description = "Los Angeles citizens with vastly separate lives collide in interweaving stories of race, loss and redemption.",
            imageUrl = "file:///android_asset/movies/image_06.png",
            rating = 7.9f,
            genres = arrayListOf("Movie", "Crime", "Drama", "Thriller")
        ),
        Movie(
            id = 7,
            name = "American Hustle",
            description = "A con man, Irving Rosenfeld, along with his seductive partner Sydney Prosser, is forced to work for a wild F.B.I. Agent, Richie DiMaso, who pushes them into a world of Jersey powerbrokers and the Mafia.",
            imageUrl = "file:///android_asset/movies/image_07.png",
            rating = 3.6f,
            genres = arrayListOf("Movie", "Crime", "Drama")
        ),
        Movie(
            id = 8,
            name = "End of Watch",
            description = "Shot documentary-style, this film follows the daily grind of two young police officers in LA who are partners and friends, and what happens when they meet criminal forces greater than themselves.",
            imageUrl = "file:///android_asset/movies/image_08.png",
            rating = 3.8f,
            genres = arrayListOf("Movie", "Action", "Adventure", "Thriller")
        )
    )

    private val downloads = arrayListOf(
        Download(
            id = 1,
            name = "Narcos",
            description = "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar, as well as the many other drug kingpins who plagued the country through the years.",
            imageUrl = "file:///android_asset/movies/image_01.png",
            rating = 4.4f,
            genres = arrayListOf("Series", "Biography", "Crime", "Drama"),
            size = "12.28GB"
        ),
        Download(
            id = 2,
            name = "Deadpool 2",
            description = "Foul-mouthed mutant mercenary Wade Wilson (a.k.a. Deadpool) assembles a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg Cable.",
            imageUrl = "file:///android_asset/movies/image_02.png",
            rating = 3.9f,
            genres = arrayListOf("Movie", "Action", "Adventure", "Comedy"),
            size = "3GB"
        ),
        Download(
            id = 3,
            name = "Annabelle",
            description = "A couple begins to experience terrifying supernatural occurrences involving a vintage doll shortly after their home is invaded by satanic cultists.",
            imageUrl = "file:///android_asset/movies/image_03.png",
            rating = 2.7f,
            genres = arrayListOf("Movie", "Horror", "Thriller", "Mystery"),
            size = "5GB"
        ),
        Download(
            id = 4,
            name = "Toy Story 4",
            description = "When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.",
            imageUrl = "file:///android_asset/movies/image_04.png",
            rating = 3.9f,
            genres = arrayListOf("Animation", "Adventure", "Comedy", "Family"),
            size = "0.9GB"
        ),
        Download(
            id = 5,
            name = "Ant-Man",
            description = "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, pull off a plan that will save the world.",
            imageUrl = "file:///android_asset/movies/image_05.png",
            rating = 3.7f,
            genres = arrayListOf("Movie", "Action", "Comedy", "Adventure"),
            size = "2.21GB"
        ),
        Download(
            id = 6,
            name = "Crash",
            description = "Los Angeles citizens with vastly separate lives collide in interweaving stories of race, loss and redemption.",
            imageUrl = "file:///android_asset/movies/image_06.png",
            rating = 7.9f,
            genres = arrayListOf("Movie", "Crime", "Drama", "Thriller"),
            size = "1.72GB"
        )
    )

    private val actors = arrayListOf(
        Actor(
            id = 1,
            name = "Al Pacino",
            about = "Alfredo James \"Al\" 'Pacino established himself as a film actor during one of cinema's most vibrant decades, the 1970s, and has become an enduring and iconic figure in the world of American movies. He was born April 25, 1940 in Manhattan, New York City, to Italian-American parents, Rose (nee Gerardi) and Sal Pacino.",
            imageUrl = "file:///android_asset/actors/image_06.jpg",
        ),
        Actor(
            id = 2,
            name = "Kate Winslet",
            about = "Ask Kate Winslet what she likes about any of her characters, and the word \"ballsy\" is bound to pop up at least once. The British actress has made a point of eschewing straightforward pretty-girl parts in favor of more devilish damsels; as a result, she's built an eclectic resume that runs the gamut from Shakespearean tragedy to modern-day mysticism and erotica.",
            imageUrl = "file:///android_asset/actors/image_01.jpg",
        ),
        Actor(
            id = 3,
            name = "Gustaf Skarsgård",
            about = "Gustaf Skarsgård was born on November 12, 1980 in Stockholm, Stockholms län, Sweden. He is an actor and director, known for Vikings (2013), Westworld (2016) and The Way Back (2010).",
            imageUrl = "file:///android_asset/actors/image_02.jpg",
        ),
        Actor(
            id = 4,
            name = "Alexander Ludwig",
            about = "After starring in the hugely successful blockbuster, The Hunger Games (2012) (for which he received two awards), Alexander has gone on to work in films such as Lone Survivor (2013), The Final Girls (2015), and Bad Boys for Life (2020), and received critical acclaim for his performance as Bjorn Ironside in the Global hit television series, Vikings (2013).",
            imageUrl = "file:///android_asset/actors/image_03.jpg",
        ),
        Actor(
            id = 5,
            name = "Katheryn Winnick",
            about = "Canadian actress, director and producer Katheryn Winnick starred in the critically acclaimed, Emmy award-winning television series Vikings, produced by MGM and The History Channel. In addition to her lead role on Vikings, an episode directed by Winnick debuted in 2020. Entertainment Weekly declared that her role as \"Lagertha may be the most exciting feminist character on TV.\" Her portrayal of the fierce shieldmaiden has garnered her several impressive accolades including a Women's Image Network award for Best Actress in a Drama Series in 2018, a nomination for a Critic's Choice Award for Best Supporting Actress in a Drama Series, a Canadian Screen Award nomination for Best Performance by a Lead Dramatic Actress (2014), Best Actress in a Drama Series by the Women's Image Network nominations in 2014, 2015, and 2016 and a Golden Maple Award nomination for Best Actress in a TV Series. In addition to these prestigious nominations, Katheryn received the Serendipity Film's Award of Excellence at the Banff World Media Festival in 2015. She was also chosen to be a jury member for the 2019 Cannes Series festival.",
            imageUrl = "file:///android_asset/actors/image_04.jpg",
        ),
        Actor(
            id = 6,
            name = "Alex Høgh Andersen",
            about = "Born and raised in a small town southwest of Copenhagen, Alex Høgh Andersen, is currently starring as a series regular in the History Channel drama, Vikings (2013). Andersen made his debut in the season 4 mid-season finale and has now been positioned as a lead.",
            imageUrl = "file:///android_asset/actors/image_05.jpg",
        )
    )
}