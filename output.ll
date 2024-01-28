define i32 @main() {
%promenna = alloca i32
%beta = alloca i32
%p = alloca i32
store i32 1024, i32* %promenna
%temp0 = load i32, i32* %promenna
%temp1 = icmp sgt i32 %temp0, 1000
br i1 %temp1, label %if.then, label %if.else
if.then:
store i32 2, i32* %beta
br label %if.end
if.else:
store i32 3, i32* %beta
br label %if.end
if.end:
store i32 0, i32* %p
ret i32 0
}
