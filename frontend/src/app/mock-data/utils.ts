export function randomString(len: number): string {
    const data = "0123456789abcdef";
    let str = "";
    for(let i = 0; i < len; i++) {
        let index = Math.floor(Math.random() * data.length);
        str += data[index];
    }
    return str;
}