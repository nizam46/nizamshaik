# nizamshaik
Coding Assesment
Explanation:
1.MaxLevelSum
Imagine you're looking at a family tree where each person is on a different level:
Level 1: Just the grandparent

Level 2: Their children

Level 3: Grandchildren, and so on

Each person has some money (positive or negative). We want to find which level has the richest combined money, and if two levels are equally rich, we pick the one closest to the top.

How the Solution Works:
Building the Tree:

We start with the first person (root) and their money

Then we add their left and right children in order

If we see "null", it means a child doesn't exist

Calculating Level Riches:

We go through the tree level by level:

First check the grandparent's money (Level 1)

Then their children combined (Level 2)

Then grandchildren combined (Level 3)

At each level, we add up all the money

Tracking the Richest Level:

We remember which level has the most money so far

If we find a richer level, we update our record

If two levels are equally rich, we keep the higher one (smaller level number)

Example Walkthrough:
Input: 1,7,0,7,-8,null,null

Tree Structure:

Level 1: Grandparent with $1

Level 2: Two children with $7 and $0

Level 3: Two grandchildren with $7 and $-8

Money Calculation:

Level 1: $1

Level 2: $7 + $0 = $7

Level 3: $7 + $-8 = $-1

Result: Level 2 has the most money ($7)

Output: 2
