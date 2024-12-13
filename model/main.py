import os
from flask import Flask, request, jsonify
import tensorflow as tf
import numpy as np

app = Flask(__name__)

# Path model di dalam container
model_path = '/app/model/saved_model/model_regresi.keras'

# Load model
model = tf.keras.models.load_model(model_path)

# Keperluan denormalisasi
max_value = 73.0
min_value = 10.8

@app.route('/predict', methods=['POST'])
def predict():
    try:
        data = request.get_json()
        
        # Extract features
        features = np.array([
            1 if data['jenis_kelamin'] == 'laki-laki' else 0,
            1 if data['riwayat_diabetes'] == 'iya' else 0,
            1 if data['tingkat_aktivitas'] == 'rendah' else 0,
            1 if data['tingkat_aktivitas'] == 'sedang' else 0,
            1 if data['tingkat_aktivitas'] == 'tinggi' else 0,
            1 if data['umur'] == 'remaja' else 0,
            1 if data['umur'] == 'dewasa' else 0,
            1 if data['umur'] == 'lansia' else 0,
            1 if 0 <= float(data['berat_badan']) <= 40 else 0,
            1 if 40 < float(data['berat_badan']) <= 60 else 0,
            1 if 60 < float(data['berat_badan']) <= 80 else 0,
            1 if 80 < float(data['berat_badan']) <= 120 else 0
        ])
        
        # Make prediction
        prediction = model.predict(features.reshape(1, -1))[0][0]  # Reshape to 2D array
        # Denormalisasi
        prediction = prediction * (max_value-min_value) + min_value
        
        return jsonify({
            'prediction': prediction
        })
        
    except Exception as e:
        return jsonify({'error': str(e)}), 400

if __name__ == '__main__':
    port = int(os.environ.get('PORT', 8080))  # Get port from environment variable
    app.run(host='0.0.0.0', port=port)  # Ensure the app listens on the correct port
