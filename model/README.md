# Machine Learning of the model
> model >> Capstone_Project_Regression_Semanis.ipynb
Regresi Problem using Deep Neural Network Architecture

Input               :
- Gula Harian (Float)
- Jenis Kelamin (laki-laki/perempuan)
- riwayat diabetes (iya/tidak)
- umur (int)
- berat badan (int)

Target              : Maksimal Asupan Gula Harian (float) 

Model Architecture  :
- 1 Input Layer (12 input neurons)
- 1 Hidden Layer using ReLU activation with l2 regularizer (64 Neurons)
- 1 Hidden Layer using ReLU activation (32 Neurons)
- 1 Output layer using linear activation (1 output neuron)

Loss Function       : Mean Squarred Error

Optimizer Function  : Adam Optimizer (learning rate = 0.001)

Model's Metrics     :
- loss: 0.0011
- val_loss: 0.0012
- mean_absolute_error: 0.0263
- val_mean_absolute_error: 0.0268
