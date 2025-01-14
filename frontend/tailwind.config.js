/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'custom-green': '#83ded1',
        'custom-blue': '#a2b1e8',
        'custom-purple': '#e0abec',
        'custom-pink': '#f5b3bd',
      },
    },
  },
  plugins: [],
}

