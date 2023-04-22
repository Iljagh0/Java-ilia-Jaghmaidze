# Java-ilia-Jaghmaidze
This is a Java web application that allows users to edit posts with the help of a special form.

## Table Creation SQL

To create the table for storing posts in MySQL, run the following SQL script:

```sql
CREATE TABLE posts (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  author VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
