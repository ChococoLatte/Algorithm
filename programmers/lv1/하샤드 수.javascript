function solution(x) {
   let sum=0;
    
    let s=x.toString().split("");
    for(let i=0;i<s.length;i++){
        sum+=Number(s[i]);
    }
    
    if(x%sum==0) return true;
    else return false;
}
