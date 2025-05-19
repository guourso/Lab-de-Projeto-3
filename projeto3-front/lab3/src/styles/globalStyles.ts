import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  body {
    font-family: 'Inter', sans-serif;
    background-color: ${props => props.theme.colors.background};
    color: ${props => props.theme.colors.foreground};
    transition: ${props => props.theme.transitions.default};
  }

  a {
    color: inherit;
    text-decoration: none;
  }

  button {
    cursor: pointer;
  }

  /* Animation classes */
  @keyframes fadeIn {
    from { opacity: 0; transform: translateY(10px); }
    to { opacity: 1; transform: translateY(0); }
  }

  @keyframes slideIn {
    from { transform: translateX(-100%); }
    to { transform: translateX(0); }
  }

  @keyframes scaleIn {
    from { opacity: 0; transform: scale(0.95); }
    to { opacity: 1; transform: scale(1); }
  }

  .animate-fade-in {
    animation: fadeIn 0.3s ease-out forwards;
  }

  .animate-slide-in {
    animation: slideIn 0.3s ease-out forwards;
  }

  .animate-scale-in {
    animation: scaleIn 0.2s ease-out forwards;
  }

  .glass-card {
    background-color: ${props => props.theme.colors.card}; 
    border: 1px solid ${props => props.theme.colors.border};
    border-radius: ${props => props.theme.radius.large};
    box-shadow: ${props => props.theme.shadows.md};
    transition: ${props => props.theme.transitions.default};
  }

  .hover-scale {
    transition: transform 0.2s ease;
    &:hover {
      transform: scale(1.01);
    }
  }
`;