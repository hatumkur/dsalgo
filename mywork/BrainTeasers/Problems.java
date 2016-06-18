/*

(1) Two given ropes which can take 1 hr to burn. How do you measure 15 mins?
        Solution:  Step1: Ignite R1 on both ends & R2 on one ends
                   Step2: When R1 burns out(START INDICATOR-SI), ignite the other end of R2
                   Step3: R2 burns out (END INDICATOR-EI). Time 15mins => EI - SI

(2) How weighs required to find out one heavier ball given a set of balls & a weight
        Solution: Ceil(log3(N)) where N => Number of balls

(3) How many doors will be open? Open & close alternate one recursively.
        Solution: floor(sqrt(N)) =>  Number of perfect square < N =>
                Numbers which odd number of factors < N

(4) Amazon interview? Who has the chance of remaining if odd position one are sent back?
        Solution: One who standing
        1_ 2 3_ 4 5_ 6 7_ 8 9_ 10
        2_ 4 6_ 8 10_
        4_ 8

        0_ 1 2_ 3 4_ 5 6_ 7 8_ 9
        1_ 3 5_ 7 9_
        3_ 7

(5) Crossing the bridge 10 5 2 1

(6) Egg drop N = 100, so that number of drops are minimum?
        Solution: 14  => 8 drops

(7) Blue eyed people leaving the island.
        Solution: All leaving on the same day. N days. N => number of blue eyed people

(8) How to identify heavier bottle of pills among 20 with a single weigh?
        Solution: 20 + 19 + ....... 1 => W1    (n) (n-1) / 2 = W2
                  W1 - W2 => Identifies the bottle

(9) Is it possible to place 31 domoinoes on a 8x8 chess board with 2 corners cut?
        Solution: No it is not possible
                  No of whites = 32
                  No of blacks = 30
                  No of board cells = 62
                  Each domino require = 1 black & 1 white to place so not possible

*/
