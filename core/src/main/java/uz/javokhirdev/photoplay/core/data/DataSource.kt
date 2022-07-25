package uz.javokhirdev.photoplay.core.data

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Download
import uz.javokhirdev.photoplay.core.domain.model.Movie

object DataSource {

    fun getWatchings(): List<Movie> = movies
    fun getDownloads(): List<Download> = downloads

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

        )
    )
}