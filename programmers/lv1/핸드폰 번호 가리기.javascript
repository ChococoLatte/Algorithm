function solution(phone_number) {
    const answer = "";
    
    const len = phone_number.length - 4;
    return "*".repeat(len) + phone_number.substring(len);
    
    return answer;
}
