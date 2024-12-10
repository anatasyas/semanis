# Machine Learning of the model
> model >> Capstone_Project_Bangkit.ipynb
API dibuat menggunakan FastAPI

## Membuat Docker Image dan menjalankannya
`sudo docker build -t capstone-ml:1.0 . `
`sudo docker container create --name ml-container --publish 8000:8000 capstone-ml`
`sudo docker container start ml-container`

model berjalan di port 8000 (bisa disesuaikan sesuai kebutuhan)

## Format Request dan Response
request API pada alamat berikut menggunakan metode **POST**
`HOST:PORT/predict`
request header wajib :
`Content-Type: Application/json`

request body berbentuk sebagai berikut
<code>{
    "input":[// 12 float number]    
}</code>

masukan input berupa list berisikan 12 angka float, tidak kurang ataupun lebih. Selebihnya akan terjadi internal server error.

jika tepat, server akan mengembalikan sebuah json sebagai berikut
<code>{
    "result": // angka 1 atau 0
}</code>

angka 1 mengindikasikan gula darah terdeteksi tinggi dan angka 0 mengindikasikan gula darah terdeteksi tidak tinggi

### Contoh
`curl -X POST -d '{"input":[-0.78065815,1.0,0.0,1.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,1.0]}' -H 'Content-Type: Application/json' 127.0.0.1:8000/predict`

akan menghasilkan

`{"result":0}`