# Contrat d'interface

## Récupération de données depuis l'API publique :
#### Requête :
https://jikan1.p.rapidapi.com/search/anime
#### Type :
GET
#### Paramètres :
- q : Le nom de l'anime à chercher (exemple : Attack%20on%20Titan)

#### Headers :
- x-rapidapi-key : La clé api
- x-rapidapi-host : jikan1.p.rapidapi.com

#### Réponse :
Objet **AnimeResponses**, exemple en format JSON :
```json
{"request_hash":"request:search:b8f91914961a0d321a0cf81571677b971d0a3491","request_cached":true,"request_cache_expiry":249971,"results":[{"mal_id":16498,"url":"https:\/\/myanimelist.net\/anime\/16498\/Shingeki_no_Kyojin","image_url":"https:\/\/cdn.myanimelist.net\/images\/anime\/10\/47347.jpg?s=29949c6e892df123f0b0563e836d3d98","title":"Shingeki no Kyojin","airing":false,"synopsis":"Centuries ago, mankind was slaughtered to near extinction by monstrous humanoid creatures called titans, forcing humans to hide in fear behind enormous concentric walls. What makes these giants truly...","type":"TV","episodes":25,"score":8.48,"start_date":"2013-04-07T00:00:00+00:00","end_date":"2013-09-29T00:00:00+00:00","members":2514320,"rated":"R"},{"mal_id":35760,"url":"https:\/\/myanimelist.net\/anime\/35760\/Shingeki_no_Kyojin_Season_3","image_url":"https:\/\/cdn.myanimelist.net\/images\/anime\/1173\/92110.jpg?s=410d006fea0608544e9861a6f261c692","title":"Shingeki no Kyojin Season 3","airing":false,"synopsis":"Still threatened by the \"Titans\" that rob them of their freedom, mankind remains caged inside the two remaining walls. Efforts to eradicate these monsters continue; however, threats arise not only fro...","type":"TV","episodes":12,"score":8.6,"start_date":"2018-07-23T00:00:00+00:00","end_date":"2018-10-15T00:00:00+00:00","members":1217052,"rated":"R"},{"mal_id":38524,"url":"https:\/\/myanimelist.net\/anime\/38524\/Shingeki_no_Kyojin_Season_3_Part_2","image_url":"https:\/\/cdn.myanimelist.net\/images\/anime\/1517\/100633.jpg?s=4540a01b5883647ade494cd28392f100","title":"Shingeki no Kyojin Season 3 Part 2","airing":false,"synopsis":"Seeking to restore humanity's diminishing hope, the Survey Corps embark on a mission to retake Wall Maria, where the battle against the merciless \"Titans\" takes the stage once again. Returning to the...","type":"TV","episodes":10,"score":9.11,"start_date":"2019-04-29T00:00:00+00:00","end_date":"2019-07-01T00:00:00+00:00","members":1078839,"rated":"R"}, ...]}
```
