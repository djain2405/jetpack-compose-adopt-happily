/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

class DogRepository {
    private val listOfDogs = listOf(
        boomer, bronson, dante, melva, kiki, pebbles, mona
    )

    suspend fun getDogs(): List<Dog> {
        return listOfDogs
    }

    suspend fun getDogById(id: String): Dog? {
        return listOfDogs.find { it.id == id }
    }
}

val boomer = Dog(
    "1",
    "Boomer",
    "2 m",
    "I’m a curious pup looking for adopters who will commit to continuing my puppy education and socialization. Ready for a home with snuggles and playtime and lots of puppy-love, I would love to attend puppy socials and meet other young dogs to grow in skills and confidence. Contact the adoption center to get more information about adopting me!",
    "2 lbs; 3 oz",
    Gender.Male,
    "Mix Terrier, American Pit Bull",
    "https://g.petango.com/photos/1145/0eab765c-ce3e-402e-85fe-08d0b89e8211.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46478164/"

)

val bronson = Dog(
    "2",
    "Bronson",
    "2 m",
    "I’m a curious pup looking for adopters who will commit to continuing my puppy education and socialization. Ready for a home with snuggles and playtime and lots of puppy-love, I would love to attend puppy socials and meet other young dogs to grow in skills and confidence. Contact the adoption center to get more information about adopting me!",
    "2 lbs; 3 oz",
    Gender.Male,
    "Mix Terrier, American Pit Bull",
    "https://g.petango.com/photos/1145/78eb39b0-157a-4540-b39b-c8267400a056.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46478169/"
)

val dante = Dog(
    "3",
    "Dante",
    "3 y",
    "You will experience an inferno of love when you get to meet Dante. This sweet boy thrives on getting attention. He is always ready for lots of pets and he just gets so happy that he is grinning ear to ear as you pet him. Dante is a smart fellow and he already knows the command “sit”. He probably knows others and we just don’t know about them yet. He is happy to take treats and he is a big fan of ham if you have any to spare. This delightful boy is waiting to meet you. If you are interested in meeting Dante, please fill out the online pre-adoption form today.",
    "55 lbs; 1 oz",
    Gender.Male,
    "Hound Mix",
    "https://g.petango.com/photos/1145/caec4f1e-b886-4019-ab6e-d203a3de1de9.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46676105/"
)

val melva = Dog(
    "4",
    "Melva",
    "3 y",
    "It seems like Melva weighs less than her name! She’s a wee bit of a gal who is friendly, active, interested in sniffing, as well as cuddling on laps. Melva is getting used to loud noises and finds that sniffing the next patch of shrubbery calms her right down. This little one may seem irresistible to pick up, but she likes trotting along at your side even more. Given the chance to show her affection, she’s a real charmer. Interested in meeting Melva? Fill out the pre-adoption interest form to let us know.",
    "4 lbs; 6 oz",
    Gender.Female,
    "Chihuahua, Short Coat Mix",
    "https://g.petango.com/photos/1145/d027e518-4d38-4533-afdf-749b1e8b76c3.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46685217/"
)

val kiki = Dog(
    "5",
    "Kiki",
    "8 y",
    "My name is Kiki. I am a big and rather strong girl who needs a new forever home. People comment on how pretty I am when they meet me. I try not to blush. I am quite friendly and snuggly with people. There aren’t enough cuddles out there to satisfy me. I am kind of like a huge teddy bear, I guess. I am a good walker and I love running around outside in the park acting silly. I do enjoy my toys as well. I could be lounging with you on your couch soon and I promise to leave some room for you. If you are interested in meeting me, please fill out the online pre-adoption form today.",
    "101 lbs; 6 oz",
    Gender.Female,
    "Mix Shepherd",
    "https://g.petango.com/photos/1145/2147f07d-6feb-45e8-9631-ad51ae9b57ed.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46673010/"
)

val pebbles = Dog(
    "6",
    "Pebbles",
    "4 y",
    "My name is Pebbles. I am told I am quite the beauty by the staff members. I can be a little shy for just a moment when I first meet you. That lasts all of about a minute and then my tail will start to wag. I love when you give me attention and I really love getting belly rubs! I am new to leash walking, but they say I am improving. Even though I am a bigger girl, I still think I am a lap dog and I will do my best to fit into your lap. It might be cozy. We are going to have so much fun together. If you are interested in meeting me, please fill out the online pre-adoption form today.",
    "79 lbs; 6 oz",
    Gender.Female,
    "Boxer Mix",
    "https://g.petango.com/photos/1145/ac00f7ae-2c8d-4c05-a7c5-d928025fb929.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46675963/"
)

val mona = Dog(
    "7",
    "Mona",
    "1 y; 6 m",
    "Mona is sweet and somewhat shy at first. She’s taking her time acclimating to everything new in her life. With happy talk and nice, yummy treats, Mona will slowly reveal her smile to you. If you keep it up, she’s likely to sidle over and give you a wittle kiss or two. Mona thinks the city is just too darn loud. Do you live in an area that would show her our quiet side? You may be just what she’s looking for and she may be the delight of your life. Interested? Please fill out the pre-adoption interest form to let us know.",
    "50 lbs; 11 oz",
    Gender.Female,
    "Australian Cattle Dog Mix",
    "https://g.petango.com/photos/1145/9e156817-1098-4261-9c42-a7b85bebdcb9.jpg",
    "https://www.sfspca.org/adoptions/pet-details/46675918/"
)
