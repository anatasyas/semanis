#!./bin/python3

import tensorflow as tf
import numpy as np
from fastapi import FastAPI
from pydantic import BaseModel
from typing import List

model = tf.keras.models.load_model('saved_model/model_1.keras')

class InputPayload(BaseModel):
    input: List[float]

class OutputPayload(BaseModel):
    result: int

# Inisialisasi aplikasi FastAPI
app = FastAPI()

@app.post("/predict", response_model=OutputPayload)
def process_payload(payload: InputPayload):
    try:
        assert len(payload.input) == 12, 'Input list must have 12 value'
        print("LOG: Predicting {}".format(payload.input))
        output = model.predict(np.array([payload.input]))
        result = 1 if output[0, 0] >= 0.5 else 0
        print("LOG: Result : {}".format(output))
        print("LOG: Returning {}".format(result))
        return {"result": result}
    except Exception as e:
        return {"error":e}

