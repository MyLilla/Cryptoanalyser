[![Typing SVG](https://readme-typing-svg.herokuapp.com?size=35&color=38C2FF&lines=Cryptoanalyser)](https://git.io/typing-svg)

<h2>Encryption and decryption of texts with the "Caesar Cipher".</h2>

Final project first module "syntax" in studying JavaRush

<h3><a>Operations:</a></h3>

* Encryption with a given key
* Decryption with known key
* Brute Force decryption
* Decryption by Statistical Analysis

<h3><a>Build: </a></h3>

```$ mvn package```

<h3 ><a>Launch:</a></h3>

```$ java -jar ./target/Cryptoanalyser-1.0-SNAPSHOT.jar```

<h3 ><a>Additionally:</a></h3>

Used color highlighting with ANSI escape code
It is possible to decrypt only those texts that was encrypted with this program.


<h3 ><a>Description of classes</a></h3>

>Root package ```ua.com.javarush.shestakova.module1``` has classes:

- ```Main``` - start point to app ```ua.com.javarush.shestakova.module1.Main```
- ```Dialod``` - builds interface fot user (ua.com.javarush.shestakova.module1.Dialog)

>Package ```algorithms``` has general app's algorithms classes
```ua.com.javarush.shestakova.module1.algorithms```

- ```Coding``` - encrypting text
- ```Decoding``` - decrypt text with key
- ```Brute Force``` - decrypt the text using all possible keys.
- ```StatisticalAnalysis``` - decrypt text based on
- text analysis to search for a character that repeats the maximum number of times.

>Package ```resourcesFromUser``` has classes:
- ```FileProcessingException``` 
- ```GetKey``` - gets key from user and save it
- ```GetText``` - gets link to the test's document from user and returns document's text
- ```WriteText``` - gets directory path and name for new document from user, creates new document name.txt
  and write into new text

>Package ```date``` has classes:

- ```Alphabet```
- ```Color```

>Package ```exceptions``` has class:

- ```FileProcessingException``` 


<h3><a>User interface</a></h3>
Operation selection
For select the required operation, you need to enter a positive integer from 0 to 4 into the console.

Input key
Asked when selecting operations with a known key
- key can be negative
- key can't be  >100 (abs)
- key can only be an integer

Input file path
- file path has to be formatted: .txt
- file path has to be absolute path

Input path and name for new file
- path has to start from root directory
- new file name hasn't to be more 15 symbols and can't contain ".", " " or "/"

In all way, text can,t be empty

<h3><a>Example:</a></h2>

```
What do you want to do? 

Encrypt text enter - 1
Decrypt text using key enter - 2
Decrypt text using "Brute Force" enter - 3
Decrypt text using "Статистический анализ" enter - 4
for exit enter - 0
1
Enter key number: 
5
Enter the full address of the text document: 
D:\Projects\Cryptoanalyser\originalText.txt
where do you want to save file, Input path to the directory: 
D:\Projects\Cryptoanalyser
Input name of new file: 
resultWithKey5
The file is saved in the specified folder
```
