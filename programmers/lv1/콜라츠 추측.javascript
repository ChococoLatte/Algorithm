function solution(num) {
    
    let x=0;
  
    while(num!=1 && x!=500){
        num = (num%2 === 0)? num/2:num*3+1;
        x++;
    }
    
    return num===1? x:-1;
   
}
