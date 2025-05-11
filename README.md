# SI_2025_lab2_232120

## Андреј Гочкков, бр. на индекс 232120

## Слика од Control Flow Graph
<img src="https://github.com/user-attachments/assets/ffa7b8a5-0d90-4d43-bcef-c9bb17d8ba2f"/>

## Цикломатичка комплексност
Формула за цикломатска комплексност:
V(G) = P + 1
P - број на предикатни јазли во графот

Следните ги броиме како предикатни јазли:
1, 4.2, 6, 8, 10, 13, 16, 18
P = 8

Со тоа добиваме:
V(G) = 8 + 1 = 9

Цикломатската комплексност на графот е 9.

## Teст случаи според доделените критериуми

### Невалидeн Item лист
    Item(null), 
    cardNumber = "Invalid"
### Item со невалидно име
    Item("Item", 10, 400, 0.1), 
    cardNumber = "Invalid"

### Невалидна картичка
    Item("Item", 10, 400, 0.1),
    cardNumber = "Invalid"

### Валиден Item со сите исполнети услови
    Item("Item", 10, 400, 0.1),
    cardNumber = "0123456789012345"


## Објаснување за напишаните unit tests
Во дадениот if statement, можни се следните четири тестови за да се покриат сите можни резулати:

### TXX
Исполнет е првиот услов и не се проверуваат останатите

    assertEquals(expectedResult_TXX, SILab2.checkCart(tff, cardNumber), 0.001);

### FTX
Грешен е првиот услов, точен е вториот

    double expectedResult_FTX = (200* 0.9 * 5) - 30;
    List<Item> ftf = List.of(new Item("Item2", 5, 200, 0.1));
    
    assertEquals(expectedResult_FTX, SILab2.checkCart(ftf, cardNumber), 0.001);

### TXX
Првите два се грешни и третиот услов е точен

    double expectedResult_FFT = (200 * 15) - 30;
    List<Item> fft = List.of(new Item("Item3", 15, 200, 0));

    assertEquals(expectedResult_FFT, SILab2.checkCart(fft, cardNumber), 0.001);

### FFF
Сите услови се грешни

    double expectedResult_FFF = 200 * 5;
    List<Item> fff = List.of(new Item("Item4", 5, 200, 0));

    assertEquals(expectedResult_FFF, SILab2.checkCart(fff, cardNumber), 0.001);
