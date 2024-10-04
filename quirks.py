import sys

def main():
    #input = sys.stdin.readlines()

    string = "6\n" + "N 1 15\n" + "N 1 10\n" + "N 2 1\n" + "P 1 30\n" + "P 2 20\n" + "P 1 20\n" 

    inp = string.splitlines()

    rozdelAPanuj(inp)

def rozdelAPanuj(inp):
    length = inp.pop(0)

    print("Initial field")
    print(inp)
    print("\n")
    
    p = cutUseLess(inp)
    t = ridSmaller(p)

    print(t)


def cutUseLess(inp):
    t = []
    tp = []
    listT = []

    for l in range(len(inp)):
        line = inp[l].split(" ")
        if line[0] == "P" and line[1] in listT:
            tp.append(line)
        if line[0] == "N":
            tp.append(line)
            if not line[1] in listT:
                listT.append(line[1])
    
    listT = []

    for i in range(len(tp) - 1, -1, -1):
        line = tp[i]
        if line[0] == "N" and line[1] in listT:
            t.append(line)
        if line[0] == "P":
            t.append(line)
            if not line[1] in listT:
                listT.append(line[1])

    t.reverse()

    return t

def ridSmaller(inp):
    types = []

    for i in inp:
        if not i[1] in types:
            types.append(i[1])

    sell_price = []
    
    for i in range(len(types)):
        toRemove = []
        for l in range(len(inp)):
            line = inp[l]
            if line[1] in types[i]:
                if line[0] == "P":
                    max_value_pair = max(sell_price, key=lambda x: x[1])
                    print("max value pair: " + str(max_value_pair))
                    toRemove = sell_price
                    toRemove.remove(max_value_pair)
                    break
                else:
                    sell_price.append([l, line[2]])
        sell_price = []
        remove = []
        for i in toRemove:
            remove.append(i[0])
        
        for i in sorted(remove, reverse=True):
            del inp[i]
        print("removing: " + str(remove))

    return inp

            
            


main()