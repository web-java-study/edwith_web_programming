**Document. 으로 사용할 수 있는 APIs**

[https://www.w3schools.com/jsref/dom_obj_document](https://www.w3schools.com/jsref/dom_obj_document).asp

**element. 으로 사용할 수 있는 APIs**

https://www.w3schools.com/jsref/dom_obj_all.asp

## DOM

웹 브라우저가 html 페이지를 인식하는 방식

## Document / Element

Document 객체는 웹 페이지 그 자체를 의미한다. 웹 페이지에 존재하는 html 요소에 접근하고자 할 때는 반드시 document 객체부터 시작하여야 한다.

Element 는 내용을 포함해 시작태그와 종료태그까지를 엘리먼트라고 한다.

```jsx
유용
tagName
textContent
nodeType

이동
childNodes
firstChild
firstElementChild
parentElement
nextSibling
nextElementSibling

DOM 조작 API
삭제, 추가, 이동, 교체 API
removeChild()
appendChild()
insertBefore()
cloneNode()
replaceChild()
closest() // 상위로 올라가면서 근접 엘리먼트 찾기

→ Todo list, DOM 추가...
```

$0 으로 해당 엘리먼트에 바로 접근 가능

```jsx
> $0;
> var div = document.createElement("div");
> var str = documemtn.createTextNode("...");
> div.appendChild(str);
[div > text node]
> $0.appendChild(div);
```

메모

[https://developer.mozilla.org/ko/docs/Web/API/Node/insertBefore](https://developer.mozilla.org/ko/docs/Web/API/Node/insertBefore)


```jsx
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <div>
    <p>When the element does not have a first child, then firstChild is null. The element is still appended to the parent, after the last child. Since the parent element did not have a first child, it did not have a last child either. Consequently, the new element is the only element, after insertion.</p>
    <p>When the element does not have a first child, then firstChild is null. The element is still appended to the parent, after the last child. Since the parent element did not have a first child, it did not have a last child either. Consequently, the new element is the only element, after insertion.</p>
  </div>
</body>
</html>

TEST
var base = document.querySelector("div");
base.insertAdjacentHTML("afterbegin", "");

var base2 = docment.querySelector("p:nth-child(3)");
base2.insertAjacentHTML("beforebegin", "");

$0.innerHTML;
+= "~~~"
$0.innerText;
```
