FROM python:3.12.8-slim

WORKDIR /app

COPY serve.py .
COPY saved_model/model_1.keras saved_model/
COPY requirements.txt .

RUN pip3 install -r requirements.txt

CMD ["uvicorn","serve:app","--reload","--host","0.0.0.0","--port","8000"]