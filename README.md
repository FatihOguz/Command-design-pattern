# Command-design-pattern


QUESTION:

You are in charge of developing a new database engine for a
bank. Your boss has asked you to design personally a design solution for modelling
transactions and database operations. A database operation can be a SELECT, an
UPDATE or an ALTER. A transaction is a series of operations (a SELECT followed by an
ALTER, or an UPDATE followed by ALTER followed by SELECT, and so on), e.g. increase
the amount of money at an account A by X, decrease the amount of money at an account
N by Y, etc. Should one of the operations fail, all others must be reversed or discarded
(known as rollback in database lingo). You are free to make assumptions concerning the
specific format (parameter number and type) of operations and the way they are executed.
a) Explain your design solution for this problem and your motivation for your decisions,
which design pattern you use (if any) and how (draw the class diagram). (15 points)
b) Code your solution’s significant classes; and explain in detail how you would implement
the rollback of transactions. (15 points)


REPORT:


In the command design pattern, I learned how to undo
the manipulations starting from the last processed
operation with a data structure like stack .
if we put the operations of the database into a data
structure, respectively.
and if we run these processes with the same method,
regardless of what they are.
We can easily return transactions
For 3 class database operations (update, alter, select)
and 3 different classes that contain them
these classes will impleent the command interface


