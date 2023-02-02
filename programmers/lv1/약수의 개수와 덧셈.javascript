function solution(left, right) {
    
    let sum=0;
    for(let i=left;i<=right;i++){
        if(EvenOdd(i)) sum+=i;
        else sum-=i;
    }
    return sum;
}

function EvenOdd(x){
    
    let m=0;
    for(let i=1;i<=x;i++){
        if(x%i === 0){
            m++;
        }
    }
    if(m%2==0) return true;
    else return false;
}
