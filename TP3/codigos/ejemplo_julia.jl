using Plots
using Distributions

# Obtenemos una muestra de numeros aleatorios con distribucion Normal
x_rand = randn(100)

# Calculamos la media
println("Media: " * string(mean(x_rand)));

# Calculamos el desvio estandar
println("Desvio Estandar: " * string(std(x_rand)));

# Calculamos la varianza
println("Varianza: " * string(var(x_rand)));

# Luego hacemos plotting de la imagen
display(plot(histogram(x_rand, bins=:scott, weights=repeat(1:5, outer=200)), title = "Distribucion Normal", label = ["Variable Aleatoria"], lw = 3))