# name = input("Diga usted su nombre: ")
# age = input("Diga usted su edad: ")
# city = input("Diga usted su ciudad: ")

# print(type(age))

proverb1 = "Hola"
proverb2 = "Me llamo pablo"

print(proverb1*2)
print(proverb1+", "+proverb2)
print(proverb1+proverb2,sep=" ",end="HUGO MARICON\n")
print(proverb1,proverb2,end="HUGO MARICON\n",sep=" ",)
print(proverb2[3:15:2])

for i in range(len(proverb1)):
    print(proverb1[i],end=" ")

edad = int(input("Dime tu edad: "))
print(type(edad))