* [stack-exchange-scraper question](https://www.hackerrank.com/challenges/stack-exchange-scraper) 

Print out the question id, summary and date in the order in which they appear on a stackexchange website. 

  1. regex for id: 
    ```
    (?:(<div (.*)?id="question-summary-))([0-9]+)(?:("(.*)?>))
    ``` 
    The id is the text inside capturing group #3

  2. regex for summary: 
    ```
    (?:(<h3>.*?\[))(.*?)(?:\]) 
    ```
    The summary is inside capturing group #2


  3. regex for relativetime: 
    ```
    (?:<span.*?(?=class="relativetime").*?>)([\w ]+?)(?:<\/span>) 
    ```
    The relativetime is inside capturing group #1

In Java after identifying the substrings using regex and adding them to an arraylist they can be printed out in the required format.

* [detect-the-email-address problem](https://www.hackerrank.com/challenges/detect-the-email-addresses) 

Output unique email addresses from given body of text.

Fairly simple regex: 

`([a-zA-Z][a-zA-Z0-9]*)@[a-zA-Z]{2,}\.[a-zA-Z]{2,}`

This is not a well defined question because a valid email can be a fairly complicated string. RFC 822 specifies a very broad set of rules for 'valid' email addresses. Check out [this](http://ex-parrot.com/~pdw/Mail-RFC822-Address.html) website for a Perl regex which is RFC 822 compliant ;) 

* [longitudes and latitudes](https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude) 

Pretty complex regex : 
 
``` 
\([\+\-]?(?!.*([\-\+\.,]\)))(?!\d{3,}\..*,)(?!0\d+\.,)(?!.*\.,)(?!9[1-9]\.)(?!90\.0*[1-9]0*,)(?!.*[\.\+\-].*[\.\+\-].*?,)(?!,.*[\.\+\-].*[\.\+\-].*?)(?!.*,\.)(?!.*,\d{4,}[\.]?)(?!.*,[2-9][0-9][0-9])(?!.*,1[8-9][1-9])(?!.*,180(\..*[1-9]+))(\d*\.?\d*,[\+\-]?\d*[\.]?\d*)\)
```

It worked on all the sample test cases but I have not tested this completely. The strategy is to start off with the most general case; \d+(\.\d+)? for numbers and then start adding negative lookaheads to customize. 

For example the regex for the range [-90,+90] could be : 

```
^[\+\-]?(?!\d{3,})(?!9[1-9])(?!90\..*[1-9]+)(?!.*[\.\+\-]$)(?!.*[\+\-].*[\-\+])\d+(\.\d+)?
```

