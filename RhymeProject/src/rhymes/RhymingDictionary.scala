package rhymes

import scala.math.min

import scala.io.Source

object RhymingDictionary {

  // isRhymeSounds will take (List("AE1", "B" ,"AH0", "K" ,"OW2", "N", "D"),List("AH0", "B" ,"UH1", "R", "T" ,"OW2", "N", "D"))

  // create a function which takes out useful dat from the file and puts it in a dictionary
  // example , Map(key -> value, ABACO -> List("AE1", "B" ,"AH0", "K" ,OW2")

  // use are findrhymes function to finish and filter ;;; those

  def vowel_or_not(thevowel: String): Boolean = {
    if (thevowel.length == 3){
      return true
      }
    else {
      return false
    }
  }

  def vowel_sim_check(char1: String, char2: String): Boolean = {
    var char1new = char1.toList
    var char2new = char2.toList
    for (a <- 0 to 1){
      if (char1new(a) != char2new(a)){
        return false
      }

    }
    return true
  }


  def isRhymeSounds(pro_1: List[String], pro_2: List[String]): Boolean = {
    var list_1 = pro_1.reverse
    var list_2 = pro_2.reverse
    var smallest = min(list_1.length, list_2.length)
    for (b <- 0 to smallest) {
      if (b < list_1.length && b < list_2.length) {
        var new1 = list_1(b)
        var new2 = list_2(b)
        if (vowel_or_not(new1) && vowel_or_not(new2)) {
          return vowel_sim_check(new1, new2)
        }
        if (new1 != new2) {
          if (vowel_or_not(new1) && vowel_or_not(new2)) {
            return vowel_sim_check(new1, new2)
          }
          else {
            return false
          }
        }

      }
    }
    return true
}


  def readFile(fileName1: String): Map[String, List[String]] = {
    var file = Source.fromFile(fileName1)
    var map: Map[String, List[String]] = Map()
    for (line <- file.getLines()){
      var newline = line.split(" ").toList
      var list: List[String] = List()
      for (i <- 2 to newline.length - 1){
        list = list :+ newline(i)
      }
      map = map + (newline(0) -> list)
    }

    return map
  }


  def findRhymes(fileName: String, word: String): List[String] = {
    var newlist1: List[String] = List()
    var newlist2: List[String] = List()
    var filenew = readFile(fileName)
    // use the var below to get the word value
    var words_value = filenew(word)
        for ((k, v) <- filenew) {
          if (isRhymeSounds(words_value, v)) {
            newlist1 = newlist1 :+ k
          }
          }
    for (final_result <- newlist1){
      if (final_result != ";;;"){
        newlist2 = newlist2 :+ final_result
      }
    }
    newlist2
        }


  def main(args: Array[String]): Unit = {
//    println(isRhymeSounds(List("BE1", "B" ,"AH0", "K" ,"OW2", "N", "T"),List("AH0", "B" ,"UH1", "R", "T" ,"OW2", "N", "D")))
//      println(readFile("/Users/islomazamov/Desktop/RhymeProject/data/cmudict-0.7b.txt"))
    println(findRhymes("/Users/islomazamov/Desktop/CSE166lec/RhymeProject/src/rhymes/cmudict-0.7b", "HELLO"))

  }
  }


