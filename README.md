

[![Typing SVG](https://readme-typing-svg.herokuapp.com?size=35&color=38C2FF&lines=Cryptoanalyser)](https://git.io/typing-svg)

<h2>Зашифровывка и расшифровывка текстов "Шифром Цезаря".</h2>

<h3><a>Доступны операции:</a></h3>

* Зашифровка по даданному ключу
* Расшифровка с известным ключом
* Расшифровка методом Brute Force
* Расшифровка методом Статистического анализа

<h3><a>Сборка проекта: </a></h3>

```$ cd Crypto2```

<h3 ><a>Запуск проекта:</a></h3>

```$ java -jar ./target/Crypto2.jar```

<h3 ><a>Дополнительно:</a></h3>

Использовано цветовое выделение с помощью ANSI escape code
(только для терминала)
Расшифровать возможно только те тексты, какие зашифрованные с помощью этой программы.

<h3 ><a>Краткое описание классов</a></h3>

>В корневом пакете ```ua.com.javarush.shestakova.module1``` находится:

- класс ```Main``` - точка входа в приложение ```ua.com.javarush.shestakova.module1.Main```
- класс ```Dialod``` - строит интерактивный интерфейся для пользователя (ua.com.javarush.shestakova.module1.Dialog)

>В пакете ```algorithms``` находятся основные алгоритмы программы
```ua.com.javarush.shestakova.module1.algorithms```

- класс ```Coding``` - алгоритм расшифровки текста по заданому ключу
- класс ```Decoding``` - алгоритм расшифровки текста так же, по заданому ключу.
- класс ```Brute Force``` - алгоритм расшифровки с перебором всех возможных ключей.
- класс ```StatisticalAnalysis``` - алгоритм расшифровке, в основе которого лежит
- анализ текста на поиск символа, повторяющегося максимальное количество раз.

>В пакете ```resourcesFromUser``` находятся классы:
- класс ```FileProcessingException``` 
- класс ```GetKey``` - принимает значения ключа шифра от пользователя и хранит его
- класс ```GetText``` - принимает ссылку на текстовый документ от пользователя и возвращает полученный по ссылке текст
- класс ```WriteText``` - принимает адрес дирректори и имя нового документа от пользователя, создает документ в формате .txt
  и записывает в него полученные данные

>В пакете ```date``` (неизменяемые данные) находятся классы:

- ```класс Alphabet``` - заданый алфавит, по которому происходят алгоритмы шифровки/дешифровки.
- ```класс Color``` - дополнение. Переменные данного класса предназначены только для запуска программы через терминал.
  (не работают с консолью Windows)


<h3><a>Пользовательский интерфейс</a></h3>
Выбор операции
Для выбора необходимой операции нужно ввести в консоль целое положительное число от 0 до 4.

Ввод ключа
Запрашивается при выборее операций с известным ключом.
- может быть отрицательным
- не должен превышать 100 по модулю
- может быть только целым числом

Ввод адреса текстового файла
- текст должен быть в формате .txt
- Должен быть указан абсолютный путь к объекту

Ввод адреса для записи и имени файла
- необходимо указать путь к директории от корневой папки
- имя файло должно быть не более 15 символов и не должно содержать ".", " " или "/"

Во всех вариантов ввода, текст не должен быть пустым

<h3><a>Пример ввода данных:</a></h2>

Введите число ключа:  
```8```

Введите полный адрес текстового документа:                         
```D://Cryptoanalyser/test.txt```

Введите адрес папки, куда сохранить полученный файл:                     
```D://Cryptoanalyser```

Введите имя нового файла:                       
```result```

В случаях если какое-либо поле будет иметь неверный формат, возвращается ответ о причине (если она известна) и программа завершается.

После успешного исполнения, в консоле появляется адрес зашифрованного/расшифрованного документа:

Пример: Результат сохранен в файле: ```D://Cryptoanalyser/result.txt```


### Примеры работы программы:
```
Что делать? 

Зашифровать текст введите - 1
Расшифровать текст с помощью ключа введите - 2
Расшифровать текст мотодом "Brute Force" введите - 3
Расшифровать текст мотодом "Статистический анализ" введите - 4
Выйти из программы введите - 0
1
Введите число ключа: 
7
Введите полный адрес текстового документа : 
D://Cryptoanalyser/test.txt
Введите адрес папки, куда сохранить полученный файл: 
D://Cryptoanalyser
Введите имя нового файла: 
test2
Результат сохранен в файле: D://Cryptoanalyser/test2.txt 
```
```
Что делать? 

Зашифровать текст введите - 1
Расшифровать текст с помощью ключа введите - 2
Расшифровать текст мотодом "Brute Force" введите - 3
Расшифровать текст мотодом "Статистический анализ" введите - 4
Выйти из программы введите - 0
три
Это не цифра. Попробуй еще

Это не цифра. Попробуй еще
9
Число должно быть от 0 до 4. Попробуй еще
1
Введите число ключа: 
768
Надежность кодировки не зависит от размера числа, так что можно поменьше: 
-13
Введите полный адрес текстового документа : 
Мой компьютер
Такого файла не существует. Проверьте файл и возвращайтесь
```