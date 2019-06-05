import filecmp

from subprocess import Popen, PIPE, STDOUT

import string, random, time
import os

def randomString(N):
    return ''.join(random.choice(string.ascii_letters)) + ''.join(random.choice(string.ascii_letters + ' ') for i in range(N-2)) + ''.join(random.choice(string.ascii_letters))

for z in range(1000000):
    print("Trying Input",z+1)
    # print("    Creating Input")
    # Creating INPUT
    MAXN = 21030

    N = random.randrange(2,MAXN+1)
    M = N-1 + random.randrange(0, (int)(0.2 * N) - 5) + 5

    print("    N :",N,"M :",M)

    INPUT = str(N) + " " + str(M) + "\n"

    E = []
    for i in range(N-1):
        E.append([i,i+1])
        INPUT += str(i) + " " + str(i+1) + "\n"

    while True:
        if len(E) == M:
            break
        S = random.randrange(0,N-1)
        D = random.randrange(S+1,N)
        if [S,D] not in E:
            E.append([S,D])
            print("\r    Edges :",len(E),end='')
            INPUT += str(S) + " " + str(D) + "\n"

    # print (E)
    # time.sleep(1000);
    print("")


    # print("    Writing to file")
    with open("input.txt", "w") as f:
        f.write(INPUT)

    ################
    print("    Running Your Program..")
    p = Popen(['java','-Xss1024M','-Xmx4096M', 'Assignment51'], stdout=PIPE, stdin=PIPE, stderr=STDOUT)    
    p.wait()
    T = p.communicate()[0].decode('ascii')

    data = INPUT.split('\n')

    # Solve program from here

    print("    Running Solver..")
    p = Popen(['./a.out'],stdout = PIPE, stdin=PIPE, stderr=STDOUT)


    #########################

    time.sleep(0.5)

    correct = False

    
    if filecmp.cmp('output.txt', 'CACHE_51'):
        correct = True;

    # os.system('clear')
    if correct:
        print("\n    Correct\n    ",end='')
        with open("CACHE_51","r") as f:
            print(f.read())
    else:
        print("    WRONG!\n")

        print(T)
            
        # print("INPUT:\n")
        # print(INPUT)
        print("PROGRAM:")
        with open("CACHE_51","r") as f:
            print(f.read())
        print("YOURS:")
        with open("output.txt","r") as f:
            print(f.read())
        
        
        break
