# Section 19: Databases 💾


## Key Terminology

  * **Database**: The container for all the data that you store.
  * **Database Dictionary**: Provides a comprehensive list of the structure and types of data in the database.
  * **Table**: A collection of related data held in the database.
  * **Field**: The basic unit of data in a table.
  * **Column**: Another name for a field.
  * **Row**: A single set of data containing all the columns in the table. Rows are also called **records**.
  * **Flat File Database**: Stores all data in a single table, which often results in a lot of duplication.

-----

## Normalization

Splitting data to reduce redundancy is known as **Normalization**. It's the process of removing duplicated and irrelevant data from tables.

The level of normalization can go up to the 6th Normal Form (6NF), but in most practical applications, it's rare to go beyond the 3rd Normal Form (3NF).

-----

## Views

A **View** is a virtual table based on the result-set of an SQL statement. It's a selection of rows and columns, possibly from more than one table.

-----

## SQLite Demo Commands 🧑‍💻

Here are some common commands used in the SQLite shell.

  * A SQLite command starts with a `.` (dot) and does not need a semicolon (e.g., `.tables`).
  * A SQLite SQL statement *must* end with a semicolon (e.g., `SELECT * FROM contacts;`).

<!-- end list -->

```sql
-- See column names in the output
.headers on

-- Create a table
CREATE TABLE contacts (name text, phone integer, email text);

-- Insert data into the table
INSERT into contacts (name, phone, email) values('RJ', 34234234, 'rj@email.com');
INSERT into contacts VALUES("R", 23434234234, "R@email.com");
INSERT into contacts (name, phone) values('K', 34234);

-- Select (query) data
SELECT * FROM contacts;
SELECT name, phone, email FROM contacts;
SELECT * from contacts WHERE name="RJ";

-- Update data (Be careful! Without WHERE, it updates all rows)
UPDATE contacts SET email="st@email.com" WHERE name = "K";

-- Delete data
DELETE FROM contacts WHERE phone="34234";

-- Backup and Restore
.backup testbackup
.restore testbackup

-- List tables in the database
.tables

-- Show the table's creation schema
.schema

-- Dump the entire database as SQL statements (schema + data)
.dump

-- Exit the shell
.exit
.quit
```

-----

## Keys and Relational Databases

A **Key** in a table is an index that speeds up searches and joins on a column. Indexed columns are sorted, allowing for much faster searching. A table can have many keys, but only one **Primary Key**, which must contain unique values.

In a **Relational Database**, the ordering of rows is undefined, similar to sets in mathematics. By defining a key, you impose an order on that column, making data operations far more efficient.

For more on SQLite's primary key behavior, see the official documentation on [SQLite Autoincrement](https://www.sqlite.org/autoinc.html).

### Example Schema with Primary Keys

```sql
CREATE TABLE songs (_id INTEGER PRIMARY KEY, track INTEGER, title TEXT NOT NULL, album INTEGER);
CREATE TABLE albums (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, artist INTEGER);
CREATE TABLE artists (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);
```

-----

## Sorting and Joining Data 🤝

### Sorting with `ORDER BY`

```sql
-- Sort by name (case-sensitive by default)
SELECT * FROM albums ORDER BY name;

-- Sort by name, ignoring case
SELECT * FROM albums ORDER BY name COLLATE NOCASE;

-- Sort in descending order
SELECT * FROM albums ORDER BY name COLLATE NOCASE DESC;

-- Sort by multiple columns
SELECT * FROM albums ORDER BY artist, name COLLATE NOCASE;
```

### Joining Tables

```sql
-- Join two tables (songs and albums)
SELECT songs.track, songs.title, albums.name
FROM songs
INNER JOIN albums ON songs.album = albums._id
ORDER BY albums.name, songs.track;

-- Join three tables (artists, albums, and songs)
SELECT artists.name, albums.name, songs.track, songs.title
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
ORDER BY artists.name, albums.name, songs.track;

-- Join with a WHERE clause
SELECT artists.name, albums.name, songs.track, songs.title
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE albums.name = "Doolittle"
ORDER BY artists.name, albums.name, songs.track;

-- Wildcard search with LIKE
SELECT artists.name, albums.name, songs.track, songs.title
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE songs.title LIKE "%doctor%"
ORDER BY artists.name, albums.name, songs.track;
```

-----

## Creating and Managing Views

### Create a View

You can rename columns in a view using the `AS` keyword.

```sql
CREATE VIEW IF NOT EXISTS artist_list AS
SELECT
    artists.name AS artist,
    albums.name AS album,
    songs.track,
    songs.title
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
ORDER BY artists.name, albums.name, songs.track;
```

### Delete a View

```sql
DROP VIEW artist_list;
```

-----

## More SQL Operations

```sql
-- Not equal operator (<>)
SELECT * FROM songs WHERE track <> 71;

-- Count rows
SELECT COUNT(*) FROM songs;
SELECT COUNT(title) From artist_list WHERE artist = "Aerosmith";

-- Count distinct (unique) values
SELECT DISTINCT title From artist_list WHERE artist = "Aerosmith" ORDER BY title;
SELECT COUNT(DISTINCT title) From artist_list WHERE artist = "Aerosmith";
```

-----

## Using SQLite with Java (JDBC) ☕

You'll need the SQLite JDBC driver. You can download the `.jar` file from the [official GitHub releases](https://github.com/xerial/sqlite-jdbc/releases).

### Connection and Execution

```java
// 1. Establish a connection
// SQLite creates the file if it doesn't exist.
String connectionString = "jdbc:sqlite:C:\\path\\to\\your\\database.db";
Connection conn = DriverManager.getConnection(connectionString);

// 2. Create a statement
Statement statement = conn.createStatement();

// 3. Execute SQL
// Create a table
statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                  "(name TEXT, phone INTEGER, email TEXT)");

// Insert data
statement.execute("INSERT INTO contacts (name, phone, email) " +
                  "VALUES('Joe', 45632, 'joe@anywhere.com')");

// Query data and process results with a ResultSet
ResultSet results = statement.executeQuery("SELECT * FROM contacts");
while(results.next()) {
    System.out.println(results.getString("name") + " " +
                       results.getInt("phone") + " " +
                       results.getString("email"));
}

// 4. Close resources
results.close();
statement.close();
conn.close();
```

### PreparedStatements (for Security)

It's best practice to use `PreparedStatement` to prevent **SQL injection attacks**. They treat user input as literal values, not as executable SQL.

**How to use `PreparedStatement`:**

1.  Declare a constant for the SQL statement with `?` as placeholders.
2.  Create a `PreparedStatement` instance using `connection.prepareStatement()`.
3.  Call the appropriate setter methods (e.g., `setString()`, `setInt()`) to replace the placeholders.
4.  Run the statement using `execute()` or `executeQuery()`.
5.  Process the results as usual.

### Transactions

A **transaction** is a sequence of SQL statements treated as a single logical unit. They ensure data integrity and are **ACID compliant**:

1.  **Atomicity**: All changes are committed, or none are.
2.  **Consistency**: The database remains in a valid state before and after the transaction.
3.  **Isolation**: Changes from one transaction aren't visible to others until committed.
4.  **Durability**: Once committed, changes are permanent.

By default, SQLite auto-commits every statement. You can control this manually in Java:

```java
try {
    // Disable auto-commit to start a transaction
    conn.setAutoCommit(false);

    // ... execute multiple SQL statements ...

    // If everything is successful, commit the transaction
    conn.commit();

} catch(SQLException e) {
    // If an error occurs, roll back the changes
    conn.rollback();
} finally {
    // Always reset to the default behavior
    conn.setAutoCommit(true);
}
```

> Can also create a GUI Program using JavaFX and connect SQLite database using JDBC.