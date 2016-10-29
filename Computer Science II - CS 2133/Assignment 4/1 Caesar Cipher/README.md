#Caesar Cipher (30 points)

The Caesar cipher is a (very insecure) method for encrypting text dating back to the Romans. It is the same alphabetic shift cipher as is used in the Secret Decoder Rings that no longer come as prizes in breakfast cereals and Cracker Jacks. Each letter in a text is replaced by the letter that occurs some fixed number of positions later in the alphabet. For instance, if the cipher implemented a shift of 3 positions, ’A’ would be transformed to ’D’, ’B’ to ’E’, ’L’ to ’O’ and so forth. Letters at the end of the alphabet wrap around to the beginning, so ’Z’ would get coded as ’C’. To decode the message, simply reverse the shift.

Java characters are represented in Unicode, which is a complex character representation that is supposed to allow writing in the alphabet of every human language, including Cyrillic, Tagalog, Hmong, Egyptian hieroglyphics, Chinese and (ahem) Klingon. However, the first 128 characters in Unicode are the same as the English-only ASCII representation that has been around since the 1950s.

In ASCII, printable English characters start at 32 (space) and end at 126 (tilde), with all of the alphabetic characters in between. The letter ’A’ is 65, ’B’ is 66, ’a’ is 97, etc. We can generalize the Caesar cipher to handle all of these characters, using an arbitrary shift size as our key.

The algorithm is, then:

```
if charValue < 32 or charValue > 126 outputChar = (char)charValue // leave alone
charValue = charValue + key
// We include both of these so that we can encode by using a positive number
// and decode using the same number as a negative
if charValue > 126 charValue = charValue - 95 //(127 - 32)
if charValue < 32 charValue = charValue + 95
outputChar = (char)charValue
```
Write a command-line Java program (no GUI this time!) that can be run as follows:

`java Caesar key infile [outfile]`

The program should open the file `infile` and encrypt each character according to key, a number. It should write the encrypted text to `outfile`, if provided, or to the screen if not.

The program should exit gracefully and print out a useful error message if it runs into any problems, including:
- Incorrect arguments
- infile not found or not readable
- outfile not writeable

**Extra Credit:** Implement the Vignere cipher, which takes a word instead of a number as a key. Use the ASCII value of each letter of the key in turn as the shift, starting over from the beginning of the key when you run out of letters. Thus if the key is “hot”, the first letter of the message should be shifted by 104 (ASCII ’h’), the second by 111 (ASCII ’o’), the third by 116, the fourth by 104 again, and so on. Also make sure that there is a way to tell the program to decode as well as encode
