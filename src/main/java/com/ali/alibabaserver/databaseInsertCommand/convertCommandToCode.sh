#!/bin/bash

# Get the directory of the script
dir=$(dirname "$0")

# Name of the database
database_name="my_database"

# Read the SQL commands from the text file
while IFS= read -r line
do
  # Select the database and use the line as the SQL command
  echo "USE $database_name; $line" | docker exec -i alibabasql mysql -uroot -p123
done < "$dir/command.txt"