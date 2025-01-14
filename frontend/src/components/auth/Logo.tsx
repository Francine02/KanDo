import logo from "../../assets/logo.png";

export default function Logo() {
    return (
        <div className="flex justify-center items-center">
            <img
                className="w-14"
                src={logo}
                alt="logo" />
        </div>
    )
}