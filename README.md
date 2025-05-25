# Втора лабораториска вежба по Софтверско инженерство

## Томи Богоески, бр. на индекс 236024

### Control Flow Graph

![CFG](https://github.com/user-attachments/assets/ed66aa5a-bfe8-46cf-8e6e-30f7108faf48)

### Цикломатска комплексност
**Формула: P+1**
- P е бројот на предикатни јазли;
- Предикантни јазли се: 52, 58, 60, 64, 68, 76, 79 и 81;
- P = 8;
- цикломатската комплексност изнесува 9;

### Тест случаи според критериумот Every Statement
Минимален број на тест случаи: 5 - за да се провери секоја можна гранка

**Тест случај 1: null list exception**
- Влез: `allItems = null, cardNumber = "1111111111111111"`
- Очекувано: RuntimeException "allItems list can't be null!"
- Цел: Ја тестира изјавата за null листа

**Тест случај 2: Invalid item exception**
- Влез: `allItems = [Item(null, 5, 100, 0.0)], cardNumber = "1111111111111111"`
- Очекувано: RuntimeException "Invalid item!"
- Цел: Ја тестира изјавата за име на предмет

**Тест случај 3: Нормално процесирање со попуст**
- Влез: `allItems = [Item("ValidItem", 5, 350, 0.1)], cardNumber = "1111111111111111"`
- Очекувано: Враќа 1545.0
- Цел: Ја тестира главната логика за калкулација и применување попуст

**Тест случај 4: Невалиден број на картичка**
- Влез: `allItems = [Item("ValidItem", 5, 100, 0.0)], cardNumber = "11111111111111112"`
- Очекувано: RuntimeException "Invalid card number!"
- Цел: Ја тестира изјавата за валидација на картичка

**Тест случај 5: Невалиден карактер во картичка**
- Влез: `allItems = [Item("ValidItem", 5, 100, 0.0)], cardNumber = "1111111111111111a"`
- Очекувано: RuntimeException "Invalid character in card number!"
- Цел: Ја тестира изјавата за погрешен карактер во картичка

### Тест случаи според критериумот Multiple Statement
За условот: `if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)`

**Минимален број на тест случаи: 8**

**Тест случај 1: A=False, B=False, C=False**
- Влез: `Item("Test", 5, 200, 0.0)`
- Услов: False || False || False = False
- Цел: Без попуст од 30

**Тест случај 2: A=False, B=False, C=True**
- Влез: `Item("Test", 15, 200, 0.0)`
- Услов: False || False || True = True
- Цел: Попуст од 30 поради голема количина

**Тест случај 3: A=False, B=True, C=False**
- Влез: `Item("Test", 5, 200, 0.1)`
- Услов: False || True || False = True
- Цел: Попуст од 30 поради постоечки попуст

**Тест случај 4: A=False, B=True, C=True**
- Влез: `Item("Test", 15, 200, 0.1)`
- Услов: False || True || True = True
- Цел: Попуст од 30 поради попуст и количина

**Тест случај 5: A=True, B=False, C=False**
- Влез: `Item("Test", 5, 350, 0.0)`
- Услов: True || False || False = True
- Цел: Попуст од 30 поради висока цена

**Тест случај 6: A=True, B=False, C=True**
- Влез: `Item("Test", 15, 350, 0.0)`
- Услов: True || False || True = True
- Цел: Попуст од 30 поради цена и количина

**Тест случај 7: A=True, B=True, C=False**
- Влез: `Item("Test", 5, 350, 0.1)`
- Услов: True || True || False = True
- Цел: Попуст од 30 поради цена и попуст

**Тест случај 8: A=True, B=True, C=True**
- Влез: `Item("Test", 15, 350, 0.1)`
- Услов: True || True || True = True
- Цел: Попуст од 30 поради сите услови
