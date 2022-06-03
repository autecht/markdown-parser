for file in test-files/*.md;
do
  /software/CSE/oracle-java-17/jdk-17.0.1/bin/java MarkdownParse $file >> results.txt
done
