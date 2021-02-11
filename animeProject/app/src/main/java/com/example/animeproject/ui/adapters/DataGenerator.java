package com.example.animeproject.ui.adapters;

import com.example.animeproject.ui.models.Anime;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<Anime> generateData() {
        List<Anime> animeList = new ArrayList<>();

        animeList.add(new Anime("Shingeki no Kyojin", "Centuries ago, mankind was slaughtered to near extinction by monstrous humanoid creatures called titans, forcing humans to hide in fear behind enormous concentric walls. What makes these giants truly...", "https://cdn.myanimelist.net//images//anime//10//47347.jpg?s=29949c6e892df123f0b0563e836d3d98"));
        animeList.add(new Anime("Shingeki no Kyojin Season 3", "Still threatened by the \\\"Titans\\\" that rob them of their freedom, mankind remains caged inside the two remaining walls. Efforts to eradicate these monsters continue; however, threats arise not only fro...", "https://cdn.myanimelist.net//images//anime//1173//92110.jpg?s=410d006fea0608544e9861a6f261c692"));
        animeList.add(new Anime("Shingeki no Kyojin Season 3 Part 2", "Seeking to restore humanity\\u2019s diminishing hope, the Survey Corps embark on a mission to retake Wall Maria, where the battle against the merciless \\\"Titans\\\" takes the stage once again. Returning to the...", "https://cdn.myanimelist.net/images/anime/1517/100633.jpg?s=4540a01b5883647ade494cd28392f100"));
        animeList.add(new Anime("Shingeki no Kyojin Movie 2: Jiyuu no Tsubasa", "Recap of episodes 14-25.", "https://cdn.myanimelist.net/images/anime/2/72510.jpg?s=4a153dacacfbd3de957bc415d7801bcf"));
        animeList.add(new Anime("Shingeki no Kyojin: The Final Season", "Gabi Braun and Falco Grice have been training their entire lives to inherit one of the seven titans under Marley's control and aid their nation in eradicating the Eldians on Paradis. However, just as...", "https://cdn.myanimelist.net/images/anime/1000/110531.jpg?s=3df5ebb6800604dc04c6a6187dd7161b"));
        animeList.add(new Anime("Shingeki no Kyojin Season 2", "For centuries, humanity has been hunted by giant, mysterious predators known as the Titans. Three mighty walls\\u2014Wall Maria, Rose, and Sheena\\u2014provided peace and protection for humanity for over a hundre...", "https://cdn.myanimelist.net/images/anime/4/84177.jpg?s=74f2f396ab23eee08691546aaa2c6fad"));
        animeList.add(new Anime("Shingeki no Kyojin: Ano Hi Kara", "Recap of the events in Shingeki no Kyojin that happened prior to episode 14.", "https://cdn.myanimelist.net/images/anime/3/51715.jpg?s=c054db6a77e6ef79b01821333be32345"));
        animeList.add(new Anime("Shingeki no Kyojin: Lost Girls", "Wall Sina, Goodbye Annie Leonhart has a job to do\\u2014and a resulting absence that must stay off her record at all costs. With no one else to turn to, she asks her comrade Hitch Dreyse to cover for her. S...", "https://cdn.myanimelist.net/images/anime/3/89417.jpg?s=3975da7b64ca5a7664fcea7fbd68f47a"));
        return animeList;
    }
}
