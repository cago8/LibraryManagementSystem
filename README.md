### Input Text that is given as a txt file
--------------------------------------------------------------------------------------------------------
```
1234567890123 Java Programming John Smith
2345678901234 Python Programming Jane Doe
123456789012X JavaScript Programming William Brown
3456789012345 Ruby Programming Lucy Adams
5678901234567 Reinforcement Learning Richard Sutton
```
--------------------------------------------------------------------------------------------------------

### Sample Output
--------------------------------------------------------------------------------------------------------
```
Book added: Java Programming, ISBN: 1234567890123, Author: John Smith
Book added: Python Programming, ISBN: 2345678901234, Author: Jane Doe
InvalidBookException: Book is invalid because the ISBN should contain only numeric characters
Book added: Ruby Programming, ISBN: 3456789012345, Author: Lucy Adams
Book added: Reinforcement Learning, ISBN: 5678901234567, Author: Richard Sutton

Loan created: Borrower: Fatma, Book: Java Programming, Due date: 2023-06-05
Loan created: Borrower: Vahideh, Book: Python Programming, Due date: 2023-06-10
NoSuchBookException: Loan aborted because the book with ISBN 123456789012X does not exist in the MyLibrary library
NoSuchBookException: Loan aborted because the book with ISBN 1111111111111 does not exist in the MyLibrary library
InvalidLoanException: Loan is invalid because the due date should be a future date

Book returned: Java Programming, ISBN: 1234567890123
Book returned: Python Programming, ISBN: 2345678901234
NoSuchBookException: Loan aborted because the book with ISBN 1111111111111 does not exist in the MyLibrary library

All loans:
Loan 1: Borrower: Fatma, Book: Java Programming, Due date: 2023-06-05, Returned: true
Loan 2: Borrower: Vahideh, Book: Python Programming, Due date: 2023-06-10, Returned: true

Matching books with 'Programming':
Book: Java Programming, ISBN: 1234567890123, Author: John Smith
Book: Python Programming, ISBN: 2345678901234, Author: Jane Doe
Book: Ruby Programming, ISBN: 3456789012345, Author: Lucy Adams
```
--------------------------------------------------------------------------------------------------------



