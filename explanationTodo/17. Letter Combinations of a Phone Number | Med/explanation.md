# Explanation of 17 <!-- omit in toc -->
- [Summary](#summary)
- [Constraints](#constraints)
- [Intuition](#intuition)
- [Approach](#approach)
- [Data Structures Used](#data-structures-used)
- [Complexity Solution](#complexity-solution)
- [Further explanation](#further-explanation)
  - [Psuedo code](#psuedo-code)
  - [Line by line](#line-by-line)
- [Edge cases to consider](#edge-cases-to-consider)
- [Further notes](#further-notes)


## Summary

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. 

## Constraints 

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

## Intuition

If we map out a small problem set we can see that it forms a tree, from then we can use a variation of dfs to find the "leaf nodes"/ max depth of the tree.

## Approach
We can map out a small problem set consisting of 2 numbers and see that it forms an tree with x child nodes with x corresponding to the number of letters a digit represents. With this, we can utilise a dfs like structure to go all the way until the end depth is reached. From this, since we'll need to simulate stack like behaviour we'll need to manually pop off the last character once we're done with it.

In terms of boilerplate, in order to have efficient lookup, we can use a hashmap to map each digit to their alphabetical representations, from then we can more easily iterate through each character.

## Data Structures Used 

Recursive structure through recursiveCombinations
Hashmap to map the "digits" integers to their corresponding alphabet string
Integer index to make sure that we use all digits
String builder to more easily build a string. 

## Complexity Solution 

Hashmap lookup O(1)
Recursion O(4^n), in the worst case solution we'll have 4 different choices to index into with a digit length of n.
Space complexity: O(h), where h is the length of digits, at the highest usage point we'll have h calls of recursiveCombinations on our stack

## Further explanation 
### Psuedo code
if (index = length of digits) {
    append current to result;
    return;
}

letters = string of characters that are mapped to the current digit at the index
for (letter in letters) {
    append current letter to string
    recurse into every combination of letter in the next index
    delete the last character
}

### Line by line
// if the recursed index is at the end of input string, then we've used up all the slots available to us
if (index == digits.length()) { 

    // add the current combination to the result array
    result.add(current.toString()); 

    // Try the next combination of numbers
    return; 
}

// In order to have quick look up of every character, we map each digit to its string set, we want to index into this to start building all combinations
letters = string of characters that are mapped to the current digit at the index

// We iterate through each letter available to us at the current digit to make sure we don't miss any.
for (letter in letters) {

    // we add the current letter to the string
    append current letter to string

    // we go on to the next digit 
    recurse into every combination of letter in the next index

    // we want to try all possible combinations available to us, without this it would result in the length of current to extend infinitely. To combat this, once we are done with the combinations afforded by this indexs character, we then delete this character and go to the next.
    delete the last character
}

## Edge cases to consider
Whether or not the input can be null or some other malformed,
eg non digits.
If it is empty, what should the return behaviour be?
If you do have an invalid input, do you skip it or throw an error altogether?
Does output order matter?
What's the maximum length of digits?
Digits outside of current range ie. 2< or >=10 -> is wraps if this happens, given that we hardcode in the definitions.

## Further notes
If letterCombinations is called multiple times, it might be logical to have a global hashmap so that we don't need to repeatedly create and initialise a hashmap.

Also also, should do we have a space allowance?