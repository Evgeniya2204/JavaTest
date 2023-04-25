# Сортировка слиянием файлов с предварительно отсортированными данными
Описание задачи 
Написать программу сортировки слиянием нескольких файлов. 
Входные файлы содержат данные одного из двух видов: целые числа или строки. Данные записаны 
в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные 
символы, строки с пробелами считаются ошибочными. Также считается, что файлы предварительно 
отсортированы. 
Результатом работы программы должен являться новый файл с объединенным содержимым 
входных файлов, отсортированным по возрастанию или убыванию путем сортировки слиянием. 
Если содержимое исходных файлов не позволяет произвести сортировку слиянием (например, 
нарушен порядок сортировки), производится частичная сортировка (насколько возможно для этого 
алгоритма, как именно обрабатывать поврежденный файл – на усмотрение разработчика). 
Выходной файл должен содержать отсортированные данные даже в случае ошибок, однако 
возможна потеря ошибочных данных. 
Необходимо самостоятельно реализовать алгоритм сортировки методом слияния и использовать 
его для сортировки содержимого файлов. Не использовать библиотечные функции сортировки. 
Алгоритм должен быть устойчив к большим файлам, не помещающимся целиком в оперативную 
память. 
