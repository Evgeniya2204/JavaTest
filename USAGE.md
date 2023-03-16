# Общая информация

Версия Java - Version 8

# Инструкция по запуску

Параметры запуска:

usage: java -jar CFT.jar [OPTIONS] output.txt input.txt

Параметры программы задаются при запуске через аргументы командной строки, по порядку:

 -a          Сортировка по возрастанию. Параметр необязательный, взаимоисключительный с -d. Применяется по умолчанию при
             отсутствии -a или -d.
 -d          Сортировка по убыванию. Параметр необязательный, взаимоисключительный с -a.
 -i          Файлы содержат целые числа. Параметр обязательный, взаимоисключительный
             с -s.
 -s          Файлы содержат строки. Параметр обязательный, взаимоисключительный с -i.

output.txt - имя выходного файла с результатом сортировки слиянием (Параметр
обязательный).

input.txt - имя входных файлов, количество которых должно быть не менее
одного (Параметр обязательный).