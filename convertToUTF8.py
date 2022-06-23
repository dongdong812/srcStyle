# This Python file uses the following encoding: utf-8
import os
filePath = "D:\\S\\2022\\project\\commit\\srs"
all_files = []
print(filePath)
for root, dirs, files in os.walk(filePath.decode('utf8').encode('cp936')):
    for dir in dirs:
        os.path.join(root,dir)
    for file in files:
        os.path.join(root,file)
        if file.endswith(".java"):
            notepad.open(root + "\\" + file)
            notepad.runMenuCommand("Encoding", "Convert to UTF-8")
            notepad.save()
            notepad.close()
       
for file in all_files:
    print(file)
print("END.")
