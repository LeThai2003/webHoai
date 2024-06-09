const previewImage = document.querySelector("[preview-image]");
if(previewImage)
{
    const inputImage = previewImage.querySelector("[image-input]");
    const seeImage = previewImage.querySelector("[image-see]");
    inputImage.addEventListener("change", (e) => {
        const [file] = inputImage.files;
        if(file)
        {
            seeImage.src = URL.createObjectURL(file);
        }
    })
}

const iconUploadAvater = document.querySelector("[icon-upload-avater]");
if(iconUploadAvater)
{
    iconUploadAvater.addEventListener("click", () => {
        const inputUpload = document.querySelector("[preview-image] input[type='file']");
        inputUpload.click();
    })
}