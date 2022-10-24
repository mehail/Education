name "2"

org 100h ; directive make tiny com file.

mov ax, k1
add ax, k2
mov divisible, ax

mov bx, k3
sub bx, k4
mov divider, bx

div bx

call print_al

ret

; variables:
divisible dd ?
divider dd ?
k1 dd 01h
k2 dd 07h
k3 dd 07C5h
k4 dd 07C2h


print_al proc
    cmp al, 0
    jne print_al_r
        push ax
        mov al, '0'
        mov ah, 0eh
        int 10h
        pop ax
        ret
print_al_r:
    pusha
    mov ah, 0
    cmp ax, 0
    je pn_done
    mov dl, 10
    div dl
    call print_al_r
    mov al, ah
    add al, 30h
    mov ah, 0eh
    int 10h
    jmp pn_done
pn_done:
    popa
    ret
endp
