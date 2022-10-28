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

ret

; variables:
k1          dd 01h           ; 1
k2          dd 07h           ; 7
k3          dd 07C5h         ; 1989
k4          dd 07C2h         ; 1986

divisible   dd ?             ; accumulator (k1 + k2)
s           dd ?             ; result 5.a
