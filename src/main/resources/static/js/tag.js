


const tagCreateTime = document.querySelectorAll(".tag-create-time");
if(tagCreateTime)
{
    console.log(tagCreateTime);
}




const sortNew = document.querySelector("[sort-new]");
const sortDefault = document.querySelector("[sort-macdinh]");

if(sortNew)
{
    const url = new URL(window.location.href);
    console.log(url);
    sortNew.addEventListener("click", () => {
        url.searchParams.set("sort", "thoigiantao");
        window.location.href = url.href;
    })
}

if(sortDefault)
{
    const url = new URL(window.location.href);
    console.log(url);
    sortDefault.addEventListener("click", () => {
        url.searchParams.delete("sort");
        window.location.href = url.href;
    })
}

const url = new URL(window.location.href);
if(url.search.includes("sort=thoigiantao"))
{
    sortNew.classList.add("active");
}
else
{
    sortDefault.classList.add("active");
}
