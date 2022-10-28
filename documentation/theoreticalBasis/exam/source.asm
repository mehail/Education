name "task 5"

org 100h                     ; directive make tiny com file.

; task 5.a
mov ax, k1
mov bx, k2
add ax, bx                   ; k1 + k2
mov divisible, ax

mov ax, k3
mov bx, k4
sub ax, bx                   ; k3 - k4

mov bx, ax
mov ax, divisible

div bx                       ; AX / BX = AX (int), DX (remains)
mov s, ax

; task 5.b
mov bx, k1
and ax, bx
mov ds:s, ax 

; task 5.c
mov ax, x1
mov bx, invx2
or ax, bx

mov bx, x3
or ax, bx  
mov f1, ax                   ; (x3 + !x2 + x1)

mov ax, x2
mov bx, x3
or ax, bx
mov f2, ax                   ; (x3 + x2)

mov ax, invx3
mov bx, invx0
or ax, bx
mov f3, ax                   ; (!x3 + !x0)  

mov ax, x0
mov bx, invx1
or ax, bx

mov bx, invx2
or ax, bx

mov bx, x3
or ax, bx
mov f4, ax                   ; (x3 + !x2 + !x1 + x0) 

mov ax, f1
mov bx, f2
and ax, bx

mov bx, f3
and ax, bx

mov bx, f4
and ax, bx                   ; (f1 + f2 + f3 + f4)

mov result, ax

ret

; variables:
k1          dd 01h           ; 1
k2          dd 07h           ; 7
k3          dd 07C5h         ; 1989
k4          dd 07C2h         ; 1986
set         dd 0010b         ; set 5.c 

divisible   dd ?             ; accumulator (k1 + k2)
s           dd ?             ; result 5.a 

invx0       dd 1             ; set inverse input bits
invx1       dd 0
invx2       dd 1
invx3       dd 0

f1          dd ?             ; temp result
f2          dd ? 
f3          dd ?
f4          dd ?   

numberSet   dd 6             ; set input bits
x0          dd 0             ; input
x1          dd 1
x2          dd 0
x3          dd 1
surname     dd 'Artyugin'    
group       dd 'ZIS-22'
result      dd ?
