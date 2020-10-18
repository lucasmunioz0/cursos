export function toCapitalize(text: string, split: boolean = true): string {
  const splitText = split ? splitWords(text).split(' ') : text.split(' ');
  const result = Array<string>(splitText.length);
  splitText.forEach(e => result.push(e.charAt(0).toUpperCase().concat(e.substr(1, e.length).toLowerCase())));

  return result.join(' ');
}

export function splitWords(text: string): string {
  let result = '';
  if (text){
    for (let i = 0; i < text.length; i++) {
      const c = text.charAt(i);
      result += c.toUpperCase() === c ? ' ' + c : c;
    }
  }

  return result;
}
