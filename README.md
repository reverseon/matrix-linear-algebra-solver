# Algeo01-20003
Tugas Besar 1 IF2123 Aljabar Linear dan Geometri - Aplikasi Matriks dalam Sistem Persamaan Linear, Determinan,
dan Aplikasinya

### Nama Kelompok: Dream Team Triangle
* 13520003 - Dzaky Fattan Rizqullah (K01)
* 13520124 - Owen Christian Wijaya (K03)
* 13520157 - Thirafi Najwan Kurniatama (K03)

### Tentang 
Tugas ini adalah tugas yang diberikan dalam rangka mata kuliah IF2123 Aljabar Linear dan Geometri, program studi Teknik 
Informatika Institut Teknologi Bandung. Program yang dibuat mencakup: 
* Implementasi matriks dalam bahasa pemrograman Java
* Implementasi metode-metode penyelesaian untuk mendapatkan determinan matriks
* Metode pencarian balikan matriks
* Aplikasi-aplikasi matriks dalam kasus nyata seperti interpolasi polinomial dan regresi linear
* Pembacaan matriks dari file .txt dan penulisan hasil perhitungan ke bentuk file .txt

### Proses Pembuatan
Program ini dibuat dalam rentang waktu 2-3 minggu menggunakan kolaborasi melalui platform GitHub. 
Program ini dibuat menggunakan:
* Java SE Runtime Environment (Class Version 60.0/61.0, JRE 1.8)
* Visual Studio Code dengan ekstensi-ekstensi formatter
* Microsoft Word untuk mengerjakan laporan secara kolaboratif

### Cara Menjalankan Program
#### Secara Otomatis
Jalankan file RunProgram.bat. Command Prompt akan mengarahkan langsung untuk menjalankan bytecode program utama.

#### Secara Manual
1. Pastikan Anda berada di direktori utama (...\Algeo01-20003)
2. Buka direktori src (via cd src) lalu ketikkan javac -d ../bin ./*.java untuk membuat file .class baru
3. Kembali ke direktor utama (via cd ..)
4. Buka Command Prompt, lalu akses folder bin (via cd bin)
5. Ketikkan java mainpr, lalu program akan berjalan di Command Prompt.

#### Memasukkan File sebagai Input 
1. Buat matriks/input di dalam sebuah file .txt yang tersimpan di folder test
2. Pada opsi pemilihan input, pilih opsi 2, lalu masukkan nama file + .txt (misal. input1.txt).
3. Apabila tidak ada imbuhan .txt pada nama file, program akan terhenti

#### Menyimpan File Luaran
1. Ketika prosedur selesai, akan muncul opsi penyimpanan sebagai file
2. Ketik y untuk menyimpan file, lalu masukkan nama file beserta imbuhan .txt (misal. output1.txt)
3. File luaran akan bisa dilihat pada folder test
4. Ketik n jika tidak ingin menyimpan file. Anda akan diarahkan kembali ke menu utama