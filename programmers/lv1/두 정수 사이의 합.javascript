function solution(a, b) {
    let ans=0;
    
    if(a>b){
        let c=a;
        a=b;
        b=c;
    }
    
    for(let i=a;i<=b;i++){
        ans+=i;
    }
    return ans;
}
