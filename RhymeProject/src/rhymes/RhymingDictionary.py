

def vowel_or_not(thevowel):
    if len(thevowel) == 3:
        return True
    else:
        return False


def vowel_sim_check(char1, char2):
    char1new = list(char1)
    char2new = list(char2)
    for a in range(0, 2):
        if char1new[a] != char2new[a]:
            return False
    return True


def isRhymeSounds(pro_1, pro_2):
    list_1 = pro_1[::-1]
    list_2 = pro_2[::-1]
    hey = min(len(pro_1), len(pro_2))
    for b in range(0, hey):
        if b < len(list_1) and b < len(list_2):
            new1 = list_1[b]
            new2 = list_2[b]
            if vowel_or_not(new1) and vowel_or_not(new2):
                return vowel_sim_check(new1, new2)
            if new1 != new2:
                if vowel_or_not(new1) and vowel_or_not(new2):
                    return vowel_sim_check(new1, new2)
                else:
                    return False
    return True


def readFile(filename1):
    map = {}
    with open(filename1) as file:
        for line in file:
            list = []
            line = line.rstrip()
            newline = line.split(" ")
            for i in range(2, len(newline)):
                list.append(newline[i])
            map[newline[0]] = list
    return map


def search(f, w):
    res = readFile(f)
    for k, v in res.items():
        if k == w.upper():
            return True
    return False
# print(search("/Users/islomazamov/Desktop/python.rhyme/data/cmudict-0.7b", ";;;"))


def getSounds(filename, word):
    empty = []
    read = readFile(filename)
    for k, v in read:
        if word == k:
            return empty.append(v)
    return empty


def findRhymes(filename, word):
    newlist1 = []
    newlist2 = []
    if search(filename, word):
        filenew = readFile(filename)
        words_value = filenew[word]
        # print(words_value)
        for a, b in filenew.items():
            # print(b)
            if isRhymeSounds(words_value, b) and a != ";;;":
                newlist1.append(a)
            # print(newlist1)
            # print(words_value)
            # print(b)
        return newlist1
    else:
        return newlist1

print(findRhymes("data/cmudict-0.7b", "WORD"))
# readFile("/Users/islomazamov/Desktop/finalpython/src/data/cmudict-0.7b")

